package com.pms.pmsapp.common.service;

import java.io.IOException;
import java.util.List;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

public interface HomeService {

	List<Index> findAllIndex();

	List<Forex> findAllForex();

	StockWrapper findIndexOrForex(String sym) throws IOException;

	void updateLivePrices();

}
