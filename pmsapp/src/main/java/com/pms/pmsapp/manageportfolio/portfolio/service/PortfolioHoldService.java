package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.common.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioHold;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

public interface PortfolioHoldService {
	List<PortfolioHold> findAllHold(long id, Pageable pageable);

	List<PortfolioHold> findAllHold(long id);

	StockWrapper findStock(String stockSym);

	void computeHoldingsJob(String stock, BigDecimal lastTransPrice);

	List<String> findAllStockSym();

	List<MktExchg> findAllMktExchg();

	long findAllCount(long id);

	void updateLivePrice(long id);
}
