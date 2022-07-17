package com.pms.pmsapp.common.repository.dao;

import java.io.IOException;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

public interface HomeDao {

	StockWrapper findIndexOrForex(String sym) throws IOException;

}
