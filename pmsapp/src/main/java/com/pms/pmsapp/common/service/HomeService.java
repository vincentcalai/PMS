package com.pms.pmsapp.common.service;

import java.util.List;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

public interface HomeService{

	List<Index> findAllIndex();
	List<Forex> findAllForex();
	StockWrapper findStock(String indexSym);
	StockWrapper findForex(String forexSym);
	void updateLastVal(Index index);
	void updateLastVal(Forex forex);
	void updateLivePrices();
	
}
