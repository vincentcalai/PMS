package com.pms.pmsapp.home.dao;

import java.util.List;

import com.pms.pmsapp.home.data.Forex;
import com.pms.pmsapp.home.data.Index;
import com.pms.pmsapp.portfolio.data.StockWrapper;

public interface HomeDao{

	List<Index> findAllIndex();
	StockWrapper findStock(String indexSym);
	void updateLastVal(Forex forex);
	List<Forex> findAllForex();
	StockWrapper findForex(String forexSym);
	void updateLastVal(Index index);
	
}
