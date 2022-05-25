package com.pms.pmsapp.performance.web;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.PortfolioPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;

import java.math.BigDecimal;
import java.util.List;

public class PerformanceForm {

	private List<String> portfolioList;
	private String selectedPortfolio;
	private PortfolioPerformance portfolioPerformance;
	private ETFPerformance etfPerformance;
	private StockPerformance stockPerformance;
	private GphyPerformance gphyPerformance;
	private BigDecimal bankBal;
	private BigDecimal bankAndInvest;
	private String msg;
	private String errorMsg;

	public List<String> getPortfolioList() {
		return portfolioList;
	}

	public void setPortfolioList(List<String> portfolioList) {
		this.portfolioList = portfolioList;
	}

	public String getSelectedPortfolio() {
		return selectedPortfolio;
	}

	public void setSelectedPortfolio(String selectedPortfolio) {
		this.selectedPortfolio = selectedPortfolio;
	}

	public PortfolioPerformance getPortfolioPerformance() {
		return portfolioPerformance;
	}

	public void setPortfolioPerformance(PortfolioPerformance portfolioPerformance) {
		this.portfolioPerformance = portfolioPerformance;
	}

	public ETFPerformance getEtfPerformance() {
		return etfPerformance;
	}

	public void setEtfPerformance(ETFPerformance etfPerformance) {
		this.etfPerformance = etfPerformance;
	}

	public StockPerformance getStockPerformance() {
		return stockPerformance;
	}

	public void setStockPerformance(StockPerformance stockPerformance) {
		this.stockPerformance = stockPerformance;
	}

	public GphyPerformance getGphyPerformance() {
		return gphyPerformance;
	}

	public void setGphyPerformance(GphyPerformance gphyPerformance) {
		this.gphyPerformance = gphyPerformance;
	}

	public BigDecimal getBankBal() {
		return bankBal;
	}

	public void setBankBal(BigDecimal bankBal) {
		this.bankBal = bankBal;
	}

	public BigDecimal getBankAndInvest() {
		return bankAndInvest;
	}

	public void setBankAndInvest(BigDecimal bankAndInvest) {
		this.bankAndInvest = bankAndInvest;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


}
