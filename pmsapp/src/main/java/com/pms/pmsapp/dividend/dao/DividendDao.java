package com.pms.pmsapp.dividend.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.pms.pmsapp.dividend.data.Dividend;
import com.pms.pmsapp.dividend.data.DividendDet;
import com.pms.pmsapp.portfolio.data.Portfolio;

public interface DividendDao{

	List<Portfolio> getPortfolios();

	long saveDivRec(Dividend dividend);

	void populateDivRec(long id, Date exDate, BigDecimal adjDiv);

	List<String> retrieveDivYears(long portId);

	List<DividendDet> retrieveDivDet(Long portId, String divYear);

	BigDecimal retrieveTotalDiv(long portId);

	BigDecimal retrieveTotalYearDiv(long portId, String divYear);

}
