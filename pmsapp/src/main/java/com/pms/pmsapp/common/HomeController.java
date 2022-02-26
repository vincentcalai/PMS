package com.pms.pmsapp.common;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.common.service.HomeService;
import com.pms.pmsapp.common.web.HomeForm;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;

import yahoofinance.quotes.stock.StockQuote;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public HomeForm findAll() {
		HomeForm homeList = new HomeForm();
		log.info("findAll in Controller");
		List<Index> indexList= homeService.findAllIndex();
		List<Forex> forexList = homeService.findAllForex();
		homeList.setIndexList(indexList);
		homeList.setForexList(forexList);
		return homeList;
	}
	
	@RequestMapping(value="/home/updateliveprices", method=RequestMethod.GET)
	public void updateLivePrices() {
		log.info("updateLivePrices in Controller");
		
		List<Index> indexList = homeService.findAllIndex();
		List<Forex> forexList = homeService.findAllForex();
		
		//update Index Live Prices
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
		
		//update Forex Live Prices
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
