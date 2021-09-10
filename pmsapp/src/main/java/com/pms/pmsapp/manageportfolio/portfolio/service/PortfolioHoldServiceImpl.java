package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.portfolio.dao.PortfolioHoldDao;
import com.pms.pmsapp.manageportfolio.portfolio.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioHold;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

@Service
public class PortfolioHoldServiceImpl implements PortfolioHoldService {
	
	private static final Logger log = LoggerFactory.getLogger(PortfolioHoldServiceImpl.class);
	
	@Autowired
	private PortfolioHoldDao portfolioHoldDao;
	
	public PortfolioHoldDao getPortfolioHoldDao() {
		return portfolioHoldDao;
	}

	public void setPortfolioHoldDao(PortfolioHoldDao portfolioHoldDao) {
		this.portfolioHoldDao = portfolioHoldDao;
	}

	public List<PortfolioHold> findAllHold(long id, Pageable pageable){
		log.info("findAll holdings in ServiceImpl");
		return portfolioHoldDao.findAllHold(id, pageable);
	}

	@Override
	public StockWrapper findStock(String stockSym) {
		log.info("findStock holdings in ServiceImpl");
		return portfolioHoldDao.findStock(stockSym);
	}
	
	@Override
	public void computeHoldingsJob(String stock, BigDecimal lastTransPrice) {
		portfolioHoldDao.computeHoldingsJob(stock, lastTransPrice);
	}

	@Override
	public List<String> findAllStockSym() {
		return portfolioHoldDao.findAllStockSym(); 
	}

	@Override
	public List<MktExchg> findAllMktExchg() {
		return portfolioHoldDao.findAllMktExchg(); 
	}

	@Override
	public long findAllCount(long id) {
		return portfolioHoldDao.findAllCount(id);
	}

}
