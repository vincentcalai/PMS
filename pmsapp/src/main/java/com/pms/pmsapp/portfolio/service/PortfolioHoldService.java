package com.pms.pmsapp.portfolio.service;

import java.math.BigDecimal;
import java.util.List;

import com.pms.pmsapp.portfolio.data.MktExchg;
import com.pms.pmsapp.portfolio.data.PortfolioHold;
import com.pms.pmsapp.portfolio.data.StockWrapper;

public interface PortfolioHoldService{
	public List<PortfolioHold> findAllHold(long id);
	public StockWrapper findStock(String stockSym);
	public void computeHoldingsJob(String stock, BigDecimal lastTransPrice);
	public List<String> findAllStockSym();
	public List<MktExchg> findAllMktExchg();
}
