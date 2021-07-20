package com.pms.pmsapp.util.quartz;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.common.service.HomeService;
import com.pms.pmsapp.portfolio.data.StockWrapper;

import yahoofinance.quotes.stock.StockQuote;

@Service
public class IndexValueJob implements Job{
	
	@Autowired
	private HomeService homeService;

	@Override
	public void execute(JobExecutionContext context) {
		
		Logger log = LoggerFactory.getLogger(IndexValueJob.class);
		
		log.info("executing indexValueJob..");
	
		List<Index> indexList = homeService.findAllIndex();
	
		for(Index index : indexList) {
			String indexSym = index.getIdxSym();
			StockWrapper stockWrapper = homeService.findStock(indexSym);
			try {
				StockQuote stockQuote = stockWrapper.getStock().getQuote(true);
				index.setLast(stockQuote.getPrice());
				index.setChange(stockQuote.getChange());
				index.setChangePct(stockQuote.getChangeInPercent());
				log.info("Index: " + index.getIdxSym() + " Last Price: " + index.getLast());
				homeService.updateLastVal(index);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		
	}
	
}
