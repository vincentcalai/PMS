package com.pms.pmsapp.home.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.home.data.Forex;
import com.pms.pmsapp.home.data.Index;
import com.pms.pmsapp.loadportfolio.data.LoadPortUpload;
import com.pms.pmsapp.portfolio.data.StockWrapper;

public interface HomeService{

	List<Index> findAllIndex();
	List<Forex> findAllForex();
	StockWrapper findStock(String indexSym);
	StockWrapper findForex(String forexSym);
	void updateLastVal(Index index);
	void updateLastVal(Forex forex);
	
	
}
