package com.pms.pmsapp.profitloss.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.profitloss.dao.ProfitLossDao;
import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;

@Service
public class ProfitLossServiceImpl implements ProfitLossService {
	
	private static final Logger log = LoggerFactory.getLogger(ProfitLossServiceImpl.class);
	
	@Autowired
	private ProfitLossDao profitLossDao;
	
	public List<String> getPortfolios(){
		return profitLossDao.getPortfolios();
	}

	@Override
	public List<String> getAllCurr() {
		return profitLossDao.getAllCurr();
	}

	@Override
	public List<UnrealPL> getUnrealisedList() {
		return profitLossDao.getUnrealisedList();
	}

	@Override
	public void computeUnrealisedList(String portfolio, String currency) {
		profitLossDao.computeUnrealisedList(portfolio, currency);
	}

	@Override
	public List<RealPL> getRealisedList(String portfolio, String currency) {
		return profitLossDao.getRealisedList(portfolio, currency);
	}

	@Override
	public void computeRealisedList(String portfolio, String currency) {
		profitLossDao.computeRealisedList(portfolio, currency);
		
	}

	@Override
	public UnrealTotalPL getUnrealisedTotalList(String portfolio) {
		return profitLossDao.getUnrealisedTotalList(portfolio);
	}

	@Override
	public RealTotalPL getRealisedTotalList(String portfolio) {
		return profitLossDao.getRealisedTotalList(portfolio);
	}

	@Override
	public StockWrapper findStock(String stockSym) {
		return profitLossDao.findStock(stockSym);
	}

	@Override
	public void updateLastVal(UnrealPL unrealPl) {
		profitLossDao.updateLastVal(unrealPl);
	}
}
