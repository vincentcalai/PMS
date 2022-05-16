package com.pms.pmsapp.profitloss.web;

import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;

import java.util.List;

public class ProfitLossForm {

	private String selectedPortfolio;

	private String selectedPnlType;
  private String selectedCurr;

	private List<String> portfolioList;
	private List<String> currList;

	private List<UnrealPL> unrealisedList;
	private List<RealPL> realisedList;

	private UnrealTotalPL unrealisedTotalList;
	private RealTotalPL realisedTotalList;

	private String errMsg;

	public ProfitLossForm() {

	}

	public ProfitLossForm(String selectedPortfolio, String selectedPnlType, String selectedCurr,
			List<String> portfolioList, List<String> currList, List<UnrealPL> unrealisedList, List<RealPL> realisedList,
			UnrealTotalPL unrealisedTotalList, RealTotalPL realisedTotalList, String errMsg) {
		super();
		this.selectedPortfolio = selectedPortfolio;
		this.selectedPnlType = selectedPnlType;
		this.selectedCurr = selectedCurr;
		this.portfolioList = portfolioList;
		this.currList = currList;
		this.unrealisedList = unrealisedList;
		this.realisedList = realisedList;
		this.unrealisedTotalList = unrealisedTotalList;
		this.realisedTotalList = realisedTotalList;
		this.errMsg = errMsg;
	}


	public List<String> getPortfolioList() {
    return portfolioList;
	}

	public void setPortfolioList(List<String> portfolioList) {
    this.portfolioList = portfolioList;
	}

	public List<String> getCurrList() {
    return currList;
	}

	public void setCurrList(List<String> currList) {
    this.currList = currList;
	}

	public List<UnrealPL> getUnrealisedList() {
    return unrealisedList;
	}

	public void setUnrealisedList(List<UnrealPL> unrealisedList) {
    this.unrealisedList = unrealisedList;
	}

	public String getSelectedPortfolio() {
    return selectedPortfolio;
	}

	public void setSelectedPortfolio(String selectedPortfolio) {
    this.selectedPortfolio = selectedPortfolio;
	}

	public String getSelectedPnlType() {
    return selectedPnlType;
	}

	public void setSelectedPnlType(String selectedPnlType) {
    this.selectedPnlType = selectedPnlType;
	}

	public String getSelectedCurr() {
    return selectedCurr;
	}

	public void setSelectedCurr(String selectedCurr) {
    this.selectedCurr = selectedCurr;
	}

	public List<RealPL> getRealisedList() {
    return realisedList;
	}

	public void setRealisedList(List<RealPL> realisedList) {
    this.realisedList = realisedList;
	}

	public String getErrMsg() {
    return errMsg;
	}

	public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
	}

	public UnrealTotalPL getUnrealisedTotalList() {
    return unrealisedTotalList;
	}

	public void setUnrealisedTotalList(UnrealTotalPL unrealisedTotalList) {
		this.unrealisedTotalList = unrealisedTotalList;
	}

	public RealTotalPL getRealisedTotalList() {
    return realisedTotalList;
	}

	public void setRealisedTotalList(RealTotalPL realisedTotalList) {
    this.realisedTotalList = realisedTotalList;
	}


}
