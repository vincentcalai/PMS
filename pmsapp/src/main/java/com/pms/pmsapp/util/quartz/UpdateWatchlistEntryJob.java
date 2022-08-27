package com.pms.pmsapp.util.quartz;

import java.math.BigDecimal;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.watchlist.service.WatchlistService;

@Service
public class UpdateWatchlistEntryJob implements Job {

	@Autowired
	private WatchlistService watchlistService;

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@Override
	public void execute(JobExecutionContext context) {

		Logger log = LoggerFactory.getLogger(UpdateWatchlistEntryJob.class);

		log.info("executing updateWatchlistEntryJob..");

		List<String> stockList = watchlistService.findAllStockSym();

		for (String stock : stockList) {
			StockWrapper stockWrapper = portfolioHoldService.findStock(stock);
			try {
				BigDecimal lastPrice = stockWrapper.getStock().getQuote(true).getPrice();
				BigDecimal change = stockWrapper.getStock().getQuote(true).getChange();
				BigDecimal changePct = stockWrapper.getStock().getQuote(true).getChangeInPercent();
				log.info("Stock: " + stock + " Last Transacted Price: " + lastPrice + " Change: " + change
						+ " Change(%): " + changePct);
				watchlistService.updateWatchlistEntryPrice(stock, lastPrice, change, changePct);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		watchlistService.updateOtherNoti();
		watchlistService.updateTriggerNoti();

	}

}
