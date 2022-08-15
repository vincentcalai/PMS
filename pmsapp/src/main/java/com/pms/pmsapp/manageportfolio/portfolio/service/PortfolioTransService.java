package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.common.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.web.PortfolioTransForm;

public interface PortfolioTransService {
	List<PortfolioTrans> findAll(long portId, Pageable pageable);

	List<MktExchg> findAllMktExchg();

	void addPortfolioTrans(PortfolioTrans portfolioTrans);

	void deletePortfolioTrans(long id);

	void populateToHolding(long id, long portId);

	int validateSellAction(PortfolioTrans portfolioTrans);

	String findSuffix(String stockExchg);

	int findCurrentStockHold(PortfolioTrans portfolioTrans);

	long findAllCount(long portId);

	List<PortfolioTrans> searchTrans(long portId, String searchText, Pageable pageable);

	long searchTransCount(long portId, String searchText);

	PortfolioTransForm retrieveStockInfo(PortfolioTransForm portfolioTransForm);

	PortfolioTransForm addPortfolioTrans(PortfolioTransForm portfolioTransForm, long portId, String username);

}
