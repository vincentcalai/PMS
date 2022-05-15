package com.pms.pmsapp.manageportfolio.portfolio.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioHold;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

public interface PortfolioHoldDao{
	List<PortfolioHold> findAllHold(long id, Pageable pageable);
	List<PortfolioHold> findAllHold(long id);
	StockWrapper findStock(String stockSym);
	void computeHoldingsJob(String stock, BigDecimal lastTransPrice);
	List<String> findAllStockSym();
	List<MktExchg> findAllMktExchg();
	long findAllCount(long id);
}
