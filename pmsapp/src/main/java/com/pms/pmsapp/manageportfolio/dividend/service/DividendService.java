package com.pms.pmsapp.manageportfolio.dividend.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.pms.pmsapp.manageportfolio.dividend.data.Dividend;
import com.pms.pmsapp.manageportfolio.dividend.data.DividendDet;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;

public interface DividendService{
	public List<Portfolio> getPortfolios();

	public long saveDivRec(Dividend dividend);

	public void populateDivRec(long id, Date exDate, BigDecimal adjDiv);

	public List<String> retrieveDivYears(long portId);

	public List<DividendDet> retrieveDivDet(Long portId,  String divYear);

	public BigDecimal retrieveTotalDiv(long portId);

	public BigDecimal retrieveTotalYearDiv(long portId, String divYear);
}
