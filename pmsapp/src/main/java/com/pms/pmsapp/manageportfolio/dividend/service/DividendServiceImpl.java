package com.pms.pmsapp.manageportfolio.dividend.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.dividend.dao.DividendDao;
import com.pms.pmsapp.manageportfolio.dividend.data.Dividend;
import com.pms.pmsapp.manageportfolio.dividend.data.DividendDet;
import com.pms.pmsapp.manageportfolio.dividend.web.DividendForm;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.util.CommonUtils;
import com.pms.pmsapp.util.constant.ConstantUtil;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes2.HistoricalDividend;

@Service
public class DividendServiceImpl implements DividendService {

	private static final Logger log = LoggerFactory.getLogger(DividendServiceImpl.class);

	@Autowired
	private DividendDao dividendDao;

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@Override
	public List<Portfolio> getPortfolios() {
		return dividendDao.getPortfolios();
	}

	@Override
	public long saveDivRec(Dividend dividend) {
		return dividendDao.saveDivRec(dividend);
	}

	@Override
	public void populateDivRec(long id, Date exDate, BigDecimal adjDiv) {
		dividendDao.populateDivRec(id, exDate, adjDiv);
	}

	@Override
	public List<String> retrieveDivYears(long portId) {
		return dividendDao.retrieveDivYears(portId);
	}

	@Override
	public List<DividendDet> retrieveDivDet(Long portId, String divYear) {
		return dividendDao.retrieveDivDet(portId, divYear);
	}

	@Override
	public BigDecimal retrieveTotalDiv(long portId) {
		return dividendDao.retrieveTotalDiv(portId);
	}

	@Override
	public BigDecimal retrieveTotalYearDiv(long portId, String divYear) {
		return dividendDao.retrieveTotalYearDiv(portId, divYear);
	}

	@Override
	public List<Dividend> findAllCurrHoldDiv() {
		return dividendDao.findAllCurrHoldDiv();
	}

	@Override
	public void updateDailyDivRec(Dividend divRec, Date exDate, BigDecimal adjDiv) {
		dividendDao.updateDailyDivRec(divRec, exDate, adjDiv);
	}

	@Override
	public void updateDivRec(long portId, String stockSym, int noOfShare) {
		dividendDao.updateDivRec(portId, stockSym, noOfShare);
	}

	@Override
	public DividendForm initPage(DividendForm dividendForm) {
		List<Portfolio> portfolios = getPortfolios();
		dividendForm.setPortfolioList(portfolios);
		return dividendForm;
	}

	@Override
	public DividendForm retrieveStockInfo(DividendForm dividendForm) {
		Map<String, String> exchgSuffmap = ConstantUtil.exchgSuffmap;

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

	@Override
	public DividendForm addDividend(DividendForm dividendForm, String username) {
		Dividend dividend = new Dividend();
		List<HistoricalDividend> dividendHist = null;
		Date divFromDate = null;
		Date divToDate = null;

		if (username != null) {
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
		dividend.setCurrHoldInd(currHoldInd ? "Y" : "N");
		long id = saveDivRec(dividend);

		divFromDate = datePurchase;
		divToDate = (dateSold == null) ? new Date() : dateSold;

		try {
			Stock stockObj = YahooFinance.get(stockSym, true);
			dividendHist = stockObj.getDividendHistory(CommonUtils.toCalendar(divFromDate),
					CommonUtils.toCalendar(divToDate));
		} catch (Exception e) {
			e.printStackTrace();
			dividendForm.setErrMsg("Unable to retrieve Stock Details. Save dividend record failed.");
			return dividendForm;
		}

		if (dividendHist.size() != 0) {
			for (HistoricalDividend rec : dividendHist) {
				BigDecimal adjDiv = rec.getAdjDividend();
				Date exDate = rec.getDate().getTime();
				populateDivRec(id, exDate, adjDiv);
			}
		}

		dividendForm.setSysMsg("Dividend Record(s) created successfully. ");

		return dividendForm;
	}

	@Override
	public DividendForm retrievePortDiv(DividendForm dividendForm) {
		// retrieve all dividend years and records
		List<DividendDet> dividendDetList = new ArrayList<DividendDet>();
		BigDecimal totalYearDividend;
		Map<String, List<DividendDet>> dividendDetMap = new HashMap<String, List<DividendDet>>();
		Map<String, BigDecimal> totalDividendDetMap = new HashMap<String, BigDecimal>();

		long portId = dividendForm.getSelectedPortfolio().getId();

		List<String> divYearsList = retrieveDivYears(portId);

		for (String divYear : divYearsList) {
			dividendDetList = retrieveDivDet(portId, divYear);
			dividendDetMap.put(divYear, dividendDetList);
			totalYearDividend = retrieveTotalYearDiv(portId, divYear);
			totalDividendDetMap.put(divYear, totalYearDividend);
		}

		dividendForm.setDivDetList(dividendDetMap);
		dividendForm.setTotalDivDetList(totalDividendDetMap);

		// tabulate total dividend and total year dividend
		BigDecimal totalDiv = retrieveTotalDiv(portId);
		dividendForm.setTotalDiv(totalDiv);

		return dividendForm;
	}
}
