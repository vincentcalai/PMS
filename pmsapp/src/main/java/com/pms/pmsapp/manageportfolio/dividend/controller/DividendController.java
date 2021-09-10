package com.pms.pmsapp.manageportfolio.dividend.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.manageportfolio.dividend.data.Dividend;
import com.pms.pmsapp.manageportfolio.dividend.data.DividendDet;
import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.dividend.web.DividendForm;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.util.CommonUtils;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes2.HistoricalDividend;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class DividendController {
	
	private static final Logger log = LoggerFactory.getLogger(DividendController.class);
	
	@Autowired
	private DividendService dividendService;
	
	@Autowired
	private PortfolioHoldService portfolioHoldService;
	
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
	
	
	@RequestMapping(value="/dividend/init", method=RequestMethod.POST)
	public DividendForm init(@RequestBody DividendForm dividendForm) {
		log.info("dividend init in Controller");
		List<Portfolio> portfolios = dividendService.getPortfolios();
		dividendForm.setPortfolioList(portfolios);
		return dividendForm;
	}
	
	@RequestMapping(value="/dividend/retrieveStockInfo", method=RequestMethod.POST)
	public DividendForm retrieveStockInfo(@RequestBody DividendForm dividendForm) {
		log.info("retrieveStockInfo Div in Controller");
		
		Map<String, String> exchgSuffmap = new HashMap<String, String>();
		exchgSuffmap.put(EXCHG_HKEX, RENAM_EXCHG_HKEX);
		exchgSuffmap.put(EXCHG_SGX, RENAM_EXCHG_SGX);
		exchgSuffmap.put(EXCHG_NYSE, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NYSE_ARCA, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NASDAQ, RENAM_EXCHG_NASDAQ);
		exchgSuffmap.put(EXCHG_OTC, RENAM_EXCHG_OTC);
		
		String stockSym = dividendForm.getStockSym();
		StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
		try {
			String stockExchg = stockWrapper.getStock().getStockExchange();
			String stockName = stockWrapper.getStock().getName();
			dividendForm.setStockExchg(exchgSuffmap.get(stockExchg));
			log.info("Stock: " + stockName + " Stock Exchg: " + stockExchg);
			dividendForm.setStockName(stockName);
		} catch (Exception e) {
			dividendForm.setErrMsg("Stock symbol not found. Fail to get stock info.");
			log.error(e.getMessage());
		}
		return dividendForm;
	}
	
	@RequestMapping(value="/dividend/add", method=RequestMethod.POST)
	public DividendForm addDividend(@RequestBody DividendForm dividendForm, Authentication authentication) throws IOException {
		 log.info("addDivided in Controller.. ");
		 
		 Dividend dividend = new Dividend();
		 List<HistoricalDividend> dividendHist = null;
		 Date divFromDate = null;
		 Date divToDate = null;
		 
		 String username = authentication.getName();
		 
		 if(username != null) {
			 dividend.setCreatedBy(username);
		 }
		 
		 long portId = dividendForm.getPortId();
		 int noOfShare = dividendForm.getNoOfShare();
		 String stockSym = dividendForm.getStockSym();
		 String stockName = dividendForm.getStockName();
		 String stockExchg = dividendForm.getStockExchg();
		 Date datePurchase = dividendForm.getDatePurchase();
		 Date dateSold = dividendForm.getDateSold();
		 Boolean currHoldInd = dividendForm.getCurrHoldInd();
		 
		 dividend.setPortId(portId);
		 dividend.setNoOfShare(noOfShare);
		 dividend.setStockSym(stockSym);
		 dividend.setStockExchg(stockExchg);
		 dividend.setStockName(stockName);
		 dividend.setDatePurchase(datePurchase);
		 dividend.setDateSold(dateSold);
		 dividend.setCurrHoldInd(currHoldInd? "Y" : "N" );
		 long id = dividendService.saveDivRec(dividend);
		 
		 divFromDate = datePurchase;
		 divToDate = (dateSold == null) ? new Date(): dateSold;
		 
		 try {
			Stock stockObj = YahooFinance.get(stockSym, true);
			dividendHist = stockObj.getDividendHistory(
				CommonUtils.toCalendar(divFromDate), CommonUtils.toCalendar(divToDate));
		 } catch(Exception e) {
			e.printStackTrace();
			dividendForm.setErrMsg("Unable to retrieve Stock Details. Save dividend record failed.");
			return dividendForm;
		 }
		 
		 if(dividendHist.size() != 0) {
			 for(HistoricalDividend rec :dividendHist) {
				 BigDecimal adjDiv = rec.getAdjDividend();
				 Date exDate = rec.getDate().getTime();
				 dividendService.populateDivRec(id, exDate, adjDiv);
			 }
		 }
		 
		 dividendForm.setSysMsg("Dividend Record(s) created successfully. ");

		
		 return dividendForm;
		 
	}
	
	@RequestMapping(value="/dividend/retrievePortDiv", method=RequestMethod.POST)
	public DividendForm retrievePortDiv(@RequestBody DividendForm dividendForm) {
		log.info("retrievePortDiv in Controller");
		
		//retrieve all dividend years and records
		List<DividendDet> dividendDetList = new ArrayList<DividendDet>();
		BigDecimal totalYearDividend;
		Map<String, List<DividendDet>> dividendDetMap = new HashMap<String, List<DividendDet>>();
		Map<String, BigDecimal> totalDividendDetMap = new HashMap<String, BigDecimal>();
		
		long portId = dividendForm.getSelectedPortfolio().getId();
		
		List<String> divYearsList = dividendService.retrieveDivYears(portId);
		
		for(String divYear :  divYearsList) {
			dividendDetList = dividendService.retrieveDivDet(portId, divYear);
			dividendDetMap.put(divYear, dividendDetList);
			totalYearDividend = dividendService.retrieveTotalYearDiv(portId, divYear);
			totalDividendDetMap.put(divYear, totalYearDividend);
		}
		
		dividendForm.setDivDetList(dividendDetMap);
		dividendForm.setTotalDivDetList(totalDividendDetMap);
		
		//tabulate total dividend and total year dividend
		BigDecimal totalDiv = dividendService.retrieveTotalDiv(portId);
		dividendForm.setTotalDiv(totalDiv);
		
		
		return dividendForm;
	}
}
