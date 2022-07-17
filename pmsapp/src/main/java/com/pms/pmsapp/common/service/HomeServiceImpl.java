package com.pms.pmsapp.common.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.common.repository.ForexRepository;
import com.pms.pmsapp.common.repository.IndexRepository;
import com.pms.pmsapp.common.repository.dao.HomeDao;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

import yahoofinance.quotes.stock.StockQuote;

@Service
public class HomeServiceImpl implements HomeService {

	private static final Logger log = LoggerFactory.getLogger(HomeServiceImpl.class);

	@Autowired
	private HomeDao homeDao;

	@Autowired
	private IndexRepository indexRepository;

	@Autowired
	private ForexRepository forexRepository;

	@Override
	public List<Index> findAllIndex() {
		return indexRepository.findAll();
	}

	@Override
	public StockWrapper findIndexOrForex(String sym) throws IOException {
		return homeDao.findIndexOrForex(sym);
	}

	@Override
	public List<Forex> findAllForex() {
		return forexRepository.findAll();
	}

	@Override
	public void updateLivePrices() {
		List<Index> indexList = findAllIndex();
		List<Forex> forexList = findAllForex();

		// update Index Live Prices
		for (Index index : indexList) {
			String indexSym = index.getIdxSym();
			try {
				StockWrapper stockWrapper = findIndexOrForex(indexSym);
				StockQuote stockQuote = stockWrapper.getStock().getQuote(true);
				index.setLast(stockQuote.getPrice());
				index.setChange(stockQuote.getChange());
				index.setChangePct(stockQuote.getChangeInPercent());
				index.setLastUpdatedDt(new Date());
				log.info("Index: " + index.getIdxSym() + " Last Price: " + index.getLast());
				indexRepository.save(index);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		// update Forex Live Prices
		for (Forex forex : forexList) {
			String forexSym = forex.getForexSymbol();
			try {
				StockWrapper stockWrapper = findIndexOrForex(forexSym);
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
