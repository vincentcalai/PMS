package com.pms.pmsapp.common.repository.dao;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

import yahoofinance.YahooFinance;

@Repository
public class HomeDaoImpl implements HomeDao {

	private static final Logger log = LoggerFactory.getLogger(HomeDaoImpl.class);

	@Override
	public StockWrapper findIndexOrForex(String sym) throws IOException {
		return new StockWrapper(YahooFinance.get(sym));
	}

}
