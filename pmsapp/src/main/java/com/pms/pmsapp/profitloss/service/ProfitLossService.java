package com.pms.pmsapp.profitloss.service;

import java.util.List;

import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;

public interface ProfitLossService{
	public List<String> getPortfolios();
	public List<String> getAllCurr();
	public List<UnrealPL> getUnrealisedList();
	public void computeUnrealisedList(String portfolio, String currency);
	public List<RealPL> getRealisedList(String portfolio, String currency);
	public void computeRealisedList(String portfolio, String currency);
	public UnrealTotalPL getUnrealisedTotalList(String portfolio);
	public RealTotalPL getRealisedTotalList(String portfolio);
}
