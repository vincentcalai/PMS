package com.pms.pmsapp.dividend.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.dividend.dao.DividendDao;
import com.pms.pmsapp.dividend.data.Dividend;
import com.pms.pmsapp.dividend.data.DividendDet;
import com.pms.pmsapp.portfolio.data.Portfolio;

@Service
public class DividendServiceImpl implements DividendService {
	
	private static final Logger log = LoggerFactory.getLogger(DividendServiceImpl.class);
	
	@Autowired
	private DividendDao dividendDao;
	
	@Override
	public List<Portfolio> getPortfolios(){
		return dividendDao.getPortfolios();
	}

	@Override
	public long saveDivRec(Dividend dividend) {
		return dividendDao.saveDivRec(dividend);
	}

	@Override
	public void populateDivRec(long id, Date exDate, BigDecimal adjDiv) {
		dividendDao.populateDivRec(id, exDate, adjDiv);
	}

	@Override
	public List<String> retrieveDivYears(long portId) {
		return dividendDao.retrieveDivYears(portId);
	}

	@Override
	public List<DividendDet> retrieveDivDet(Long portId, String divYear) {
		return dividendDao.retrieveDivDet(portId, divYear);
	}

	@Override
	public BigDecimal retrieveTotalDiv(long portId) {
		return dividendDao.retrieveTotalDiv(portId);
	}

	@Override
	public BigDecimal retrieveTotalYearDiv(long portId, String divYear) {
		return dividendDao.retrieveTotalYearDiv(portId, divYear);
	}
}
