package com.pms.pmsapp.util.quartz;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.repository.ForexRepository;
import com.pms.pmsapp.common.service.HomeService;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

import yahoofinance.quotes.stock.StockQuote;

@Service
public class ForexValueJob implements Job {

	@Autowired
	private HomeService homeService;

	@Autowired
	private ForexRepository forexRepository;

	@Override
	public void execute(JobExecutionContext context) {

		Logger log = LoggerFactory.getLogger(ForexValueJob.class);

		log.info("executing forexValueJob..");

		List<Forex> forexList = homeService.findAllForex();

		for (Forex forex : forexList) {
			String forexSym = forex.getForexSymbol();
			try {
				StockWrapper stockWrapper = homeService.findIndexOrForex(forexSym);
				StockQuote stockQuote = stockWrapper.getStock().getQuote(true);
				forex.setLast(stockQuote.getPrice());
				forex.setChange(stockQuote.getChange());
				forex.setChangePct(stockQuote.getChangeInPercent());
				forex.setLastUpdatedDt(new Date());
				log.info("Forex: " + forex.getForexSymbol() + " Last Rate: " + forex.getLast());
				forexRepository.save(forex);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

	}

}
