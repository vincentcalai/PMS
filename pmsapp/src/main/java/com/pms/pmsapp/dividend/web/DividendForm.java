package com.pms.pmsapp.dividend.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pms.pmsapp.dividend.data.DividendDet;
import com.pms.pmsapp.portfolio.data.Portfolio;

public class DividendForm {

	private Portfolio selectedPortfolio;

	private List<Portfolio> portfolioList;
	
	private BigDecimal totalDiv;
	
	private Map<String, List<DividendDet>> divDetList;
	private Map<String, BigDecimal> totalDivDetList;
	
	private Long id;
	private Long portId;
	private String stockName;
	private String stockSym;
	private String stockExchg;
	private	Integer noOfShare;
	private Date datePurchase;
	private Date dateSold;
	private Boolean currHoldInd;
	private String createdBy;
	private String sysMsg;
	private String errMsg;
	
	public DividendForm() {
		super();
	}
	
	public DividendForm(Portfolio selectedPortfolio, List<Portfolio> portfolioList, BigDecimal totalDiv,
			Map<String, List<DividendDet>> divDetList, Map<String, BigDecimal> totalDivDetList, Long id, Long portId,
			String stockName, String stockSym, String stockExchg, Integer noOfShare, Date datePurchase, Date dateSold,
			Boolean currHoldInd, String createdBy, String sysMsg, String errMsg) {
		super();
		this.selectedPortfolio = selectedPortfolio;
		this.portfolioList = portfolioList;
		this.totalDiv = totalDiv;
		this.divDetList = divDetList;
		this.totalDivDetList = totalDivDetList;
		this.id = id;
		this.portId = portId;
		this.stockName = stockName;
		this.stockSym = stockSym;
		this.stockExchg = stockExchg;
		this.noOfShare = noOfShare;
		this.datePurchase = datePurchase;
		this.dateSold = dateSold;
		this.currHoldInd = currHoldInd;
		this.createdBy = createdBy;
		this.sysMsg = sysMsg;
		this.errMsg = errMsg;
	}

	public Portfolio getSelectedPortfolio() {
		return selectedPortfolio;
	}

	public void setSelectedPortfolio(Portfolio selectedPortfolio) {
		this.selectedPortfolio = selectedPortfolio;
	}

	public List<Portfolio> getPortfolioList() {
		return portfolioList;
	}

	public void setPortfolioList(List<Portfolio> portfolioList) {
		this.portfolioList = portfolioList;
	}


	public BigDecimal getTotalDiv() {
		return totalDiv;
	}

	public void setTotalDiv(BigDecimal totalDiv) {
		this.totalDiv = totalDiv;
	}

	public Map<String, List<DividendDet>> getDivDetList() {
		return divDetList;
	}

	public void setDivDetList(Map<String, List<DividendDet>> divDetList) {
		this.divDetList = divDetList;
	}

	public Map<String, BigDecimal> getTotalDivDetList() {
		return totalDivDetList;
	}

	public void setTotalDivDetList(Map<String, BigDecimal> totalDivDetList) {
		this.totalDivDetList = totalDivDetList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPortId() {
		return portId;
	}

	public void setPortId(Long portId) {
		this.portId = portId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockSym() {
		return stockSym;
	}

	public void setStockSym(String stockSym) {
		this.stockSym = stockSym;
	}

	public String getStockExchg() {
		return stockExchg;
	}

	public void setStockExchg(String stockExchg) {
		this.stockExchg = stockExchg;
	}

	public Integer getNoOfShare() {
		return noOfShare;
	}

	public void setNoOfShare(Integer noOfShare) {
		this.noOfShare = noOfShare;
	}

	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	public Date getDateSold() {
		return dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}

	public Boolean getCurrHoldInd() {
		return currHoldInd;
	}

	public void setCurrHoldInd(Boolean currHoldInd) {
		this.currHoldInd = currHoldInd;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSysMsg() {
		return sysMsg;
	}

	public void setSysMsg(String sysMsg) {
		this.sysMsg = sysMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}