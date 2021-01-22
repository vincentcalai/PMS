package com.pms.pmsapp.portfolio.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.portfolio.data.MktExchg;
import com.pms.pmsapp.portfolio.data.PortfolioHold;
import com.pms.pmsapp.portfolio.data.StockWrapper;

public interface PortfolioHoldService{
	public List<PortfolioHold> findAllHold(long id, Pageable pageable);
	public StockWrapper findStock(String stockSym);
	public void computeHoldingsJob(String stock, BigDecimal lastTransPrice);
	public List<String> findAllStockSym();
	public List<MktExchg> findAllMktExchg();
	public long findAllCount(long id);
}
