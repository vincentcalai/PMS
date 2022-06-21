package com.pms.pmsapp.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.HomeController;
import com.pms.pmsapp.common.dao.HomeDao;
import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

import yahoofinance.quotes.stock.StockQuote;

@Service
public class HomeServiceImpl implements HomeService {
	
	private static final Logger log = LoggerFactory.getLogger(HomeServiceImpl.class);
	
	@Autowired
	private HomeDao homeDao;

	@Override
	public List<Index> findAllIndex() {
		return homeDao.findAllIndex();
	}

	@Override
	public StockWrapper findStock(String indexSym) {
		return homeDao.findStock(indexSym);
	}

	@Override
	public void updateLastVal(Index index) {
		homeDao.updateLastVal(index);
	}

	@Override
	public List<Forex> findAllForex() {
		return homeDao.findAllForex();
	}

	@Override
	public StockWrapper findForex(String forexSym) {
		return homeDao.findForex(forexSym);
	}

	@Override
	public void updateLastVal(Forex forex) {
		homeDao.updateLastVal(forex);
	}

	@Override
	public void updateLivePrices() {
		List<Index> indexList = findAllIndex();
		List<Forex> forexList = findAllForex();

		//update Index Live Prices
		for(Index index : indexList) {
			String indexSym = index.getIdxSym();
			StockWrapper stockWrapper = findStock(indexSym);
			try {
				StockQuote stockQuote = stockWrapper.getStock().getQuote(true);
				index.setLast(stockQuote.getPrice());
				index.setChange(stockQuote.getChange());
				index.setChangePct(stockQuote.getChangeInPercent());
				log.info("Index: " + index.getIdxSym() + " Last Price: " + index.getLast());
				updateLastVal(index);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		//update Forex Live Prices
		for(Forex forex : forexList) {
			String forexSym = forex.getForexSymbol();
			StockWrapper stockWrapper = findForex(forexSym);
			try {
				StockQuote stockQuote = stockWrapper.getStock().getQuote(true);
				forex.setLast(stockQuote.getPrice());
				forex.setChange(stockQuote.getChange());
				forex.setChangePct(stockQuote.getChangeInPercent());
				log.info("Forex: " + forex.getForexSymbol() + " Last Rate: " + forex.getLast());
				updateLastVal(forex);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		
	}	

}
