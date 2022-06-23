package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.portfolio.dao.PortfolioTransDao;
import com.pms.pmsapp.manageportfolio.portfolio.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

@Service
public class PortfolioTransServiceImpl implements PortfolioTransService {

	private static final Logger log = LoggerFactory.getLogger(PortfolioTransServiceImpl.class);

	private static final String EXCHG_HKEX = "HKSE";
	private static final String EXCHG_SGX = "SES";
	private static final String EXCHG_NYSE = "NYSE";
	private static final String EXCHG_NYSE_ARCA = "NYSEArca";
	private static final String EXCHG_NASDAQ_GS = "NasdaqGS";
	private static final String EXCHG_NASDAQ_GM = "NasdaqGM";
	private static final String EXCHG_NASDAQ_CM = "NasdaqCM";
	private static final String EXCHG_OTC = "Other OTC";

	private static final String RENAM_EXCHG_HKEX = "HKEX";
	private static final String RENAM_EXCHG_SGX = "SGX";
	private static final String RENAM_EXCHG_NYSE = "NYSE";
	private static final String RENAM_EXCHG_NASDAQ = "NASDAQ";
	private static final String RENAM_EXCHG_OTC = "OTC";
	
	private static final String SELL_ACTION = "SELL";

	public static Map<String, String> exchgSuffmap;
	
	static {
		exchgSuffmap = new HashMap<>();
		exchgSuffmap.put(EXCHG_HKEX, RENAM_EXCHG_HKEX);
		exchgSuffmap.put(EXCHG_SGX, RENAM_EXCHG_SGX);
		exchgSuffmap.put(EXCHG_NYSE, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NYSE_ARCA, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NASDAQ_GS, RENAM_EXCHG_NASDAQ);
		exchgSuffmap.put(EXCHG_NASDAQ_GM, RENAM_EXCHG_NASDAQ);
		exchgSuffmap.put(EXCHG_NASDAQ_CM, RENAM_EXCHG_NASDAQ);
		exchgSuffmap.put(EXCHG_OTC, RENAM_EXCHG_OTC);
	}

	@Autowired
	private PortfolioTransDao portfolioTransDao;

	@Autowired
	private PortfolioHoldService portfolioHoldService;
	
	@Autowired
	private DividendService dividendService;

	public List<PortfolioTrans> findAll(long portId, Pageable pageable) {
		log.info("findAll Trans in ServiceImpl");
		return portfolioTransDao.findAll(portId, pageable);
	}

	public List<MktExchg> findAllMktExchg() {
		log.info("findAllMktExchg Trans in ServiceImpl");
		return portfolioTransDao.findAllMktExchg();
	}

	public void addPortfolioTrans(PortfolioTrans portfolioTrans) {
		portfolioTransDao.addPortfolioTrans(portfolioTrans);
	}

	public void deletePortfolioTrans(long id) {
		portfolioTransDao.deletePortfolioTrans(id);
	}

	public void populateToHolding(long id, long portId) {
		portfolioTransDao.populateToHolding(id, portId);
	}

	public long getNextTransID() {
		return portfolioTransDao.getNextTransID();
	}

	public int validateSellAction(PortfolioTrans portfolioTrans) {
		return portfolioTransDao.validateSellAction(portfolioTrans);
	}

	@Override
	public String findSuffix(String stockExchg) {
		return portfolioTransDao.findSuffix(stockExchg);
	}

	@Override
	public int findCurrentStockHold(PortfolioTrans portfolioTrans) {
		return portfolioTransDao.findCurrentStockHold(portfolioTrans);
	}

	@Override
	public long findAllCount(long portId) {
		return portfolioTransDao.findAllCount(portId);
	}

	@Override
	public List<PortfolioTrans> searchTrans(long portId, String searchText, Pageable pageable) {
		return portfolioTransDao.searchTrans(portId, searchText, pageable);
	}

	@Override
	public long searchTransCount(long portId, String searchText) {
		return portfolioTransDao.searchTransCount(portId, searchText);
	}

	@Override
	public PortfolioTrans retrieveStockInfo(PortfolioTrans portfolioTrans) {
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

	@Override
	public PortfolioTrans addPortfolioTrans(PortfolioTrans portfolioTrans, long portId, String username) {
		long id = 0;
		 int sellActionCheck = 0;

		 if(username != null) {
			 portfolioTrans.setCreatedBy(username);
		 }

		 String action = portfolioTrans.getAction();
		 int noOfShare = portfolioTrans.getNoOfShare();
		 String stockSym = portfolioTrans.getStockSymbol();
		 String stockExchg = portfolioTrans.getStockExchg();
		 String transPrice = portfolioTrans.getTransPrice().toString();
		 Date backDatedDate = portfolioTrans.getBackDatedDate() == null ? new Date(): portfolioTrans.getBackDatedDate();
		 portfolioTrans.setPortId(portId);
		 portfolioTrans.setStockSymbol(stockSym);
		 portfolioTrans.setBackDatedDate(backDatedDate);

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
			sellActionCheck = validateSellAction(portfolioTrans);
		}

		if(sellActionCheck >= 0) {
			 id = getNextTransID();
			 portfolioTrans.setId(id);

			 addPortfolioTrans(portfolioTrans);

			 populateToHolding(id, portId);

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

}
