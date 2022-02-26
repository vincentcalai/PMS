package com.pms.pmsapp.manageportfolio.portfolio.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioHold;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

public interface PortfolioHoldDao{
	public List<PortfolioHold> findAllHold(long id, Pageable pageable);
	public List<PortfolioHold> findAllHold(long id);
	public StockWrapper findStock(String stockSym);
	public void computeHoldingsJob(String stock, BigDecimal lastTransPrice);
	public List<String> findAllStockSym();
	public List<MktExchg> findAllMktExchg();
	public long findAllCount(long id);
}
