package com.pms.pmsapp.profitloss.dao;

import java.util.List;

import com.pms.pmsapp.portfolio.data.PortfolioHold;
import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;

public interface ProfitLossDao{

	List<String> getPortfolios();
	List<String> getAllCurr();
	List<UnrealPL> getUnrealisedList();
	void computeUnrealisedList(String portfolio, String currency);
	List<RealPL> getRealisedList(String portfolio, String currency);
	void computeRealisedList(String portfolio, String currency);
	UnrealTotalPL getUnrealisedTotalList(String portfolio);
	RealTotalPL getRealisedTotalList(String portfolio);

}
