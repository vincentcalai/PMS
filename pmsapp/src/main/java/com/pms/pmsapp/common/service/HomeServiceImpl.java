package com.pms.pmsapp.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.dao.HomeDao;
import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.portfolio.data.StockWrapper;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeDao homeDao;

	@Override
	public List<Index> findAllIndex() {
		return homeDao.findAllIndex();
	}

	@Override
	public StockWrapper findStock(String indexSym) {
		return homeDao.findStock(indexSym);
	}

	@Override
	public void updateLastVal(Index index) {
		homeDao.updateLastVal(index);
	}

	@Override
	public List<Forex> findAllForex() {
		return homeDao.findAllForex();
	}

	@Override
	public StockWrapper findForex(String forexSym) {
		return homeDao.findForex(forexSym);
	}

	@Override
	public void updateLastVal(Forex forex) {
		homeDao.updateLastVal(forex);
	}	
}
