package com.pms.pmsapp.portfolio.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.common.quartz.ComputeHoldingsJob;
import com.pms.pmsapp.portfolio.data.MktExchg;
import com.pms.pmsapp.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.portfolio.data.StockWrapper;
import com.pms.pmsapp.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.portfolio.service.PortfolioTransService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PortfolioTransController {
	
	private static final Logger log = LoggerFactory.getLogger(PortfolioTransController.class);
	
	@Autowired
	private PortfolioTransService portfolioTransService;
	
	@Autowired
	private PortfolioHoldService portfolioHoldService;
	
	private final String SELL_ACTION = "SELL";
	
	private final String EXCHG_HKEX = "HKSE";
	private final String EXCHG_SGX = "SES";
	private final String EXCHG_NYSE = "NYSE";
	private final String EXCHG_NASDAQ = "NasdaqGS";
	
	private final String RENAM_EXCHG_HKEX = "HKEX";
	private final String RENAM_EXCHG_SGX = "SGX";
	private final String RENAM_EXCHG_NYSE = "NYSE";
	private final String RENAM_EXCHG_NASDAQ = "NASDAQ";
	
	private final String SUFFIX_HKEX = ".HK";
	private final String SUFFIX_SGX = ".SI";
	private final String SUFFIX_NYSE = new String("");
	private final String SUFFIX_NASDAQ = new String("");
	
	
	@RequestMapping(value="/portfolio/transaction/{portId}", method=RequestMethod.GET)
	public List<PortfolioTrans> findAll(@PathVariable long portId) {
		log.info("findAll Trans in Controller");
		int currentStockHold = 0;
		
		List<PortfolioTrans> portfolioTrans= portfolioTransService.findAll(portId);
		for(int i = 0; i < portfolioTrans.size(); i++) {
			currentStockHold = portfolioTransService.findCurrentStockHold(portfolioTrans.get(i));
			portfolioTrans.get(i).setCurrentStockHold(currentStockHold);
		}
		
		return portfolioTrans;
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
		exchgSuffmap.put(EXCHG_NASDAQ, RENAM_EXCHG_NASDAQ);
		
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
		 String stockSymSuff = "";
		 
		 Map<String, String> exchgSuffmap = new HashMap<String, String>();
		 exchgSuffmap.put(EXCHG_HKEX, SUFFIX_HKEX);
		 exchgSuffmap.put(EXCHG_SGX, SUFFIX_SGX);
		 exchgSuffmap.put(EXCHG_NYSE, SUFFIX_NYSE);
		 exchgSuffmap.put(EXCHG_NASDAQ, SUFFIX_NASDAQ);
		 
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
		 
//		 suffix = portfolioTransService.findSuffix(stockExchg);
//		 log.info("suffix: " + suffix);
//		 
//		 if(suffix != null) {
//			 stockSym = stockSym + suffix;
//		 }
		 
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
