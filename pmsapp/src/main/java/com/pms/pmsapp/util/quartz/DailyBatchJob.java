package com.pms.pmsapp.util.quartz;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.dividend.data.Dividend;
import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.util.CommonUtils;
import com.pms.pmsapp.watchlist.service.WatchlistService;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes2.HistoricalDividend;

@Service
public class DailyBatchJob implements Job{

	@Autowired
	private WatchlistService watchlistService;

	@Autowired
	private DividendService dividendService;

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@Override
	public void execute(JobExecutionContext context) {

		Logger log = LoggerFactory.getLogger(UpdateWatchlistEntryJob.class);

		log.info("executing dailyBatchJob..");

		watchlistService.deleteAllOtherNoti();

		UpdateDailyDivRec();

	}


	public void UpdateDailyDivRec() {

		//update dividend records for all portfolios

		List<HistoricalDividend> dividendHist = null;

		List<Dividend> divList = dividendService.findAllCurrHoldDiv();

		for(Dividend divRec : divList) {

			String stockSym = divRec.getStockSym();
			Date divFromDate = divRec.getDatePurchase();

			 try {
				Stock stockObj = YahooFinance.get(stockSym, true);
				dividendHist = stockObj.getDividendHistory(
					CommonUtils.toCalendar(divFromDate), CommonUtils.toCalendar(new Date()));
			 } catch(Exception e) {
				e.printStackTrace();
			 }

			 if(dividendHist.size() != 0) {
				 for(HistoricalDividend rec : dividendHist) {
					 BigDecimal adjDiv = rec.getAdjDividend();
					 Date exDate = rec.getDate().getTime();
					 dividendService.updateDailyDivRec(divRec, exDate, adjDiv);
				 }
			 }
		}

	}
}
