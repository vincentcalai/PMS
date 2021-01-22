package com.pms.pmsapp.util.quartz;

import java.math.BigDecimal;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.pms.pmsapp.portfolio.data.StockWrapper;
import com.pms.pmsapp.portfolio.service.PortfolioHoldService;

@Service
public class ComputeHoldingsJob implements Job{
	
	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@Override
	public void execute(JobExecutionContext context) {
		
		Logger log = LoggerFactory.getLogger(ComputeHoldingsJob.class);
		
		log.info("executing computeHoldingsJob..");
	
		List<String> stockList = portfolioHoldService.findAllStockSym();
	
		for(String stock : stockList) {
			StockWrapper stockWrapper = portfolioHoldService.findStock(stock);
			try {
				BigDecimal lastTransPrice = stockWrapper.getStock().getQuote(true).getPrice();
				log.info("Stock: " + stock + " Last Transacted Price: " + lastTransPrice);
				portfolioHoldService.computeHoldingsJob(stock, lastTransPrice);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		
	}
	
}
