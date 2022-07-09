package com.pms.pmsapp.common.dao;

import java.util.List;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

public interface HomeDao {

	List<Index> findAllIndex();

	StockWrapper findStock(String indexSym);

	void updateLastVal(Forex forex);

	List<Forex> findAllForex();

	StockWrapper findForex(String forexSym);

	void updateLastVal(Index index);

}
