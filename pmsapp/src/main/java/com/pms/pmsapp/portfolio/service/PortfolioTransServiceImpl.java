package com.pms.pmsapp.portfolio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.portfolio.dao.PortfolioDao;
import com.pms.pmsapp.portfolio.dao.PortfolioTransDao;
import com.pms.pmsapp.portfolio.data.MktExchg;
import com.pms.pmsapp.portfolio.data.Portfolio;
import com.pms.pmsapp.portfolio.data.PortfolioTrans;

@Service
public class PortfolioTransServiceImpl implements PortfolioTransService {
	
	private static final Logger log = LoggerFactory.getLogger(PortfolioTransServiceImpl.class);
	
	@Autowired
	private PortfolioTransDao portfolioTransDao;
	
	public PortfolioTransDao getPortfolioTransDao() {
		return portfolioTransDao;
	}
//
//	public void setPortfolioDao(PortfolioDao portfolioDao) {
//		this.portfolioDao = portfolioDao;
//	}

	public List<PortfolioTrans> findAll(long portId){
		log.info("findAll Trans in ServiceImpl");
		return portfolioTransDao.findAll(portId);
	}
	
	public List<MktExchg> findAllMktExchg(){
		log.info("findAllMktExchg Trans in ServiceImpl");
		return portfolioTransDao.findAllMktExchg();
	}
	
	public void addPortfolioTrans(PortfolioTrans portfolioTrans) {
		portfolioTransDao.addPortfolioTrans(portfolioTrans);
	}
	
	public void deletePortfolioTrans(long id) {
		portfolioTransDao.deletePortfolioTrans(id);
	}
	
	public void populateToHolding(long id, long portId) {
		portfolioTransDao.populateToHolding(id, portId);
	}
	
	public long getNextTransID() {
		return portfolioTransDao.getNextTransID();
	}

	public int validateSellAction(PortfolioTrans portfolioTrans) {
		return portfolioTransDao.validateSellAction(portfolioTrans);
	}

	@Override
	public String findSuffix(String stockExchg) {
		return portfolioTransDao.findSuffix(stockExchg);
	}

	@Override
	public int findCurrentStockHold(PortfolioTrans portfolioTrans) {
		return portfolioTransDao.findCurrentStockHold(portfolioTrans);
	}
	
}
