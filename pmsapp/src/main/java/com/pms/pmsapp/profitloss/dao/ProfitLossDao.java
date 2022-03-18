package com.pms.pmsapp.profitloss.dao;

import java.util.List;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;

public interface ProfitLossDao{

	public List<String> getPortfolios();
	public List<String> getAllCurr();
	public List<UnrealPL> getUnrealisedList();
	public void computeUnrealisedList(String portfolio, String currency);
	public List<RealPL> getRealisedList(String portfolio, String currency);
	public void computeRealisedList(String portfolio, String currency);
	public UnrealTotalPL getUnrealisedTotalList(String portfolio);
	public RealTotalPL getRealisedTotalList(String portfolio);
	public StockWrapper findStock(String stockSym);
	public void updateLastVal(UnrealPL unrealPl);

}
