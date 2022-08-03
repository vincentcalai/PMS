package com.pms.pmsapp.manageportfolio.portfolio.repository.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.common.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;

public interface PortfolioTransDao {
	List<PortfolioTrans> findAll(long portId, Pageable pageable);

	List<MktExchg> findAllMktExchg();

	void addPortfolioTrans(PortfolioTrans portfolioTrans);

	void populateToHolding(long id, long portId);

	int validateSellAction(PortfolioTrans portfolioTrans);

	int findCurrentStockHold(PortfolioTrans portfolioTrans);

	List<PortfolioTrans> searchTrans(long portId, String searchText, Pageable pageable);
}
