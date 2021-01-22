package com.pms.pmsapp.portfolio.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.portfolio.data.MktExchg;
import com.pms.pmsapp.portfolio.data.PortfolioTrans;

public interface PortfolioTransDao{
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
	long searchTransCount(long portId, String searchText);
}
