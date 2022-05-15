package com.pms.pmsapp.manageportfolio.portfolio.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.portfolio.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioTransService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PortfolioTransController {

	private static final Logger log = LoggerFactory.getLogger(PortfolioTransController.class);

	@Autowired
	private PortfolioTransService portfolioTransService;

	@Autowired
	private DividendService dividendService;

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	private final String SELL_ACTION = "SELL";

	private final String EXCHG_HKEX = "HKSE";
	private final String EXCHG_SGX = "SES";
	private final String EXCHG_NYSE = "NYSE";
	private final String EXCHG_NYSE_ARCA = "NYSEArca";
	private final String EXCHG_NASDAQ = "NasdaqGS";
	private final String EXCHG_OTC = "Other OTC";

	private final String RENAM_EXCHG_HKEX = "HKEX";
	private final String RENAM_EXCHG_SGX = "SGX";
	private final String RENAM_EXCHG_NYSE = "NYSE";
	private final String RENAM_EXCHG_NASDAQ = "NASDAQ";
	private final String RENAM_EXCHG_OTC = "OTC";

	@RequestMapping(value="/portfolio/transaction/{portId}", method=RequestMethod.GET)
	public Page<PortfolioTrans> findAll(@RequestParam("page") int page, @RequestParam("size") int size,
			@PathVariable long portId) {
		log.info("findAll Trans in Controller");

		Pageable pageable = PageRequest.of(page-1, size);
		int currentStockHold = 0;

		List<PortfolioTrans> portfolioTrans= portfolioTransService.findAll(portId, pageable);
		long totalRec = portfolioTransService.findAllCount(portId);

		for(int i = 0; i < portfolioTrans.size(); i++) {
			currentStockHold = portfolioTransService.findCurrentStockHold(portfolioTrans.get(i));
			portfolioTrans.get(i).setCurrentStockHold(currentStockHold);
		}

		PageImpl<PortfolioTrans> transPage = new PageImpl(portfolioTrans, pageable, totalRec);
		return transPage;
	}

	@RequestMapping(value="/portfolio/transaction/search/{portId}", method=RequestMethod.POST)
	public Page<PortfolioTrans> searchTrans(@RequestParam("page") int page, @RequestParam("size") int size,
			@PathVariable long portId, @RequestBody(required = false) String searchText) {
		log.info("searchText Trans in Controller");
		log.info("searchText: " + searchText);

		Pageable pageable = PageRequest.of(page-1, size);
		int currentStockHold = 0;

		if (searchText == null || "".equals(searchText)) {
			searchText = "%";
		}else{
			searchText = searchText + "%";
		}

		List<PortfolioTrans> portfolioTrans= portfolioTransService.searchTrans(portId, searchText, pageable);
		long totalRec = portfolioTransService.searchTransCount(portId, searchText);

		for(int i = 0; i < portfolioTrans.size(); i++) {
			currentStockHold = portfolioTransService.findCurrentStockHold(portfolioTrans.get(i));
			portfolioTrans.get(i).setCurrentStockHold(currentStockHold);
		}

		PageImpl<PortfolioTrans> transPage = new PageImpl(portfolioTrans, pageable, totalRec);
		return transPage;
	}

	@RequestMapping(value="/portfolio/transaction/mktexchg", method=RequestMethod.GET)
	public List<MktExchg> findAllMktExchg() {
		log.info("findAllMktExchg Trans in Controller");
		List<MktExchg> mktExchg= portfolioTransService.findAllMktExchg();
		return mktExchg;
	}

	@RequestMapping(value="/portfolio/transaction/stockhold", method=RequestMethod.POST)
	public int findCurrentStockHold(@RequestBody PortfolioTrans portfolioTrans) {
		log.info("findCurrentStockHold Trans in Controller");
		int currentStockHold= portfolioTransService.findCurrentStockHold(portfolioTrans);
		return currentStockHold;
	}

	@RequestMapping(value="/portfolio/retrieveStockInfo", method=RequestMethod.POST)
	public PortfolioTrans retrieveStockInfo(@RequestBody PortfolioTrans portfolioTrans) {
		log.info("retrieveStockInfo Trans in Controller");

		Map<String, String> exchgSuffmap = new HashMap<String, String>();
		exchgSuffmap.put(EXCHG_HKEX, RENAM_EXCHG_HKEX);
		exchgSuffmap.put(EXCHG_SGX, RENAM_EXCHG_SGX);
		exchgSuffmap.put(EXCHG_NYSE, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NYSE_ARCA, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NASDAQ, RENAM_EXCHG_NASDAQ);
		exchgSuffmap.put(EXCHG_OTC, RENAM_EXCHG_OTC);

		String stockSym = portfolioTrans.getStockSymbol();
		StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
		try {
			String stockExchg = stockWrapper.getStock().getStockExchange();
			String stockName = stockWrapper.getStock().getName();
			BigDecimal transPrice = stockWrapper.getStock().getQuote(true).getPrice();
			portfolioTrans.setStockExchg(exchgSuffmap.get(stockExchg));
			log.info("Stock: " + stockName + " Trans Price: " + transPrice);
			portfolioTrans.setStockName(stockName);
			portfolioTrans.setTransPrice(transPrice);
		} catch (Exception e) {
			portfolioTrans.setErrMsg("Stock symbol not found. Fail to get stock info.");
			log.error(e.getMessage());
		}
		return portfolioTrans;
	}

	@RequestMapping(value="/portfolio/transaction/add/{portId}", method=RequestMethod.POST)
	public PortfolioTrans addTrans(@RequestBody PortfolioTrans portfolioTrans, @PathVariable long portId, Authentication authentication) {
		 log.info("addPortfolioTrans in Controller.. ");
		 log.info("portId:  " + portId);
		 long id = 0;
		 int sellActionCheck = 0;

		 String username = authentication.getName();

		 if(username != null) {
			 portfolioTrans.setCreatedBy(username);
		 }

		 String action = portfolioTrans.getAction();
		 int noOfShare = portfolioTrans.getNoOfShare();
		 String stockSym = portfolioTrans.getStockSymbol();
		 String stockExchg = portfolioTrans.getStockExchg();
		 String transPrice = portfolioTrans.getTransPrice().toString();
		 portfolioTrans.setPortId(portId);
		 portfolioTrans.setStockSymbol(stockSym);

		if(noOfShare <= 0) {
			 portfolioTrans.setErrMsg("Invalid No. Of Share. No. Of Share should be more than 0. Save transaction failed.");
			 return portfolioTrans;
		}

		StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
		if((stockWrapper.getStock() == null || stockWrapper.getStock().getQuote().getPrice() == null)) {
			 portfolioTrans.setErrMsg("Stock Symbol is invalid, unable to get stock price. Save transaction failed.");
			 return portfolioTrans;
		}

		if(portfolioTrans.getAction().equals(SELL_ACTION)) {
			sellActionCheck = portfolioTransService.validateSellAction(portfolioTrans);
		}

		if(sellActionCheck >= 0) {
			 id = portfolioTransService.getNextTransID();
			 portfolioTrans.setId(id);

			 portfolioTransService.addPortfolioTrans(portfolioTrans);

			 portfolioTransService.populateToHolding(id, portId);

			 if(portfolioTrans.getAction().equals(SELL_ACTION)) {
				 dividendService.updateDivRec(portId, stockSym, noOfShare);
			 }

			 try {
					BigDecimal lastTransPrice = stockWrapper.getStock().getQuote(true).getPrice();
					log.info("Stock: " + stockSym + " Last Transacted Price: " + lastTransPrice);
					portfolioHoldService.computeHoldingsJob(stockSym, lastTransPrice);
			 } catch (Exception e) {
				 	portfolioTrans.setErrMsg("An unexpected error occurred while updating real time price. Update of real time price failed.");
					log.error(e.getMessage());
			 }

			 portfolioTrans.setSystemMsg("Transaction created successfully. Transaction "
				 		+ action + " " + stockExchg + ":" + stockSym + " " + noOfShare + " AT " + transPrice );

		}else {
			 portfolioTrans.setErrMsg("You do not have sufficient shares in your holdings to register this trade.");
		 }

		return portfolioTrans;

	}

//	@RequestMapping(value="/portfolio/transaction/delete/{id}", method=RequestMethod.DELETE)
//	public PortfolioTrans deletePortfolioTrans(@PathVariable long id) {
//		log.info("deletePortfolioTrans in Controller");
//		PortfolioTrans portfolioTrans = new PortfolioTrans();
//
//		portfolioTransService.deletePortfolioTrans(id);
//
//		portfolioTrans.setSystemMsg("Transaction deleted successfully.");
//
//		return portfolioTrans;
//	}

}
