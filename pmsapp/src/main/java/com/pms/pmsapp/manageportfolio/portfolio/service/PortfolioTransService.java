package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;

public interface PortfolioTransService{
	public List<PortfolioTrans> findAll(long portId, Pageable pageable);
	public List<MktExchg> findAllMktExchg();
	public void addPortfolioTrans(PortfolioTrans portfolioTrans);
	public void deletePortfolioTrans(long id);
	public void populateToHolding(long id, long portId);
	public long getNextTransID();
	public int validateSellAction(PortfolioTrans portfolioTrans);
	public String findSuffix(String stockExchg);
	public int findCurrentStockHold(PortfolioTrans portfolioTrans);
	public long findAllCount(long portId);
	public List<PortfolioTrans> searchTrans(long portId, String searchText, Pageable pageable);
	public long searchTransCount(long portId, String searchText);
}
