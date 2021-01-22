package com.pms.pmsapp.util.quartz;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.home.data.Forex;
import com.pms.pmsapp.home.service.HomeService;
import com.pms.pmsapp.portfolio.data.StockWrapper;

import yahoofinance.quotes.stock.StockQuote;

@Service
public class ForexValueJob implements Job{
	
	@Autowired
	private HomeService homeService;

	@Override
	public void execute(JobExecutionContext context) {
		
		Logger log = LoggerFactory.getLogger(ForexValueJob.class);
		
		log.info("executing forexValueJob..");
	
		List<Forex> forexList = homeService.findAllForex();
	
		for(Forex forex : forexList) {
			String forexSym = forex.getForexSymbol();
			StockWrapper stockWrapper = homeService.findForex(forexSym);
			try {
				StockQuote stockQuote = stockWrapper.getStock().getQuote(true);
				forex.setLast(stockQuote.getPrice());
				forex.setChange(stockQuote.getChange());
				forex.setChangePct(stockQuote.getChangeInPercent());
				log.info("Forex: " + forex.getForexSymbol() + " Last Rate: " + forex.getLast());
				homeService.updateLastVal(forex);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		
	}
	
}
