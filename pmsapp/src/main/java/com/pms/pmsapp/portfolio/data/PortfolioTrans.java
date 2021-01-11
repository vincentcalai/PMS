package com.pms.pmsapp.portfolio.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PortfolioTrans{

	private Long id;
	private Long portId;
	private String stockName;
	private String stockSymbol;
	private String stockExchg;
	private Integer noOfShare;
	private BigDecimal transPrice;
	private BigDecimal totalAmt;
	private String action;
	private String createdBy;
	private Date createdDt;
	private String remarks;
	private Integer currentStockHold;
	private String systemMsg;
	private String errMsg;

	public PortfolioTrans() {
	}

	public PortfolioTrans(Long id, Long portId, String stockName, String stockSymbol, String stockExchg,
			Integer noOfShare, BigDecimal transPrice, BigDecimal totalAmt, String action,
			String createdBy, Date createdDt, String remarks, Integer currentStockHold, String systemMsg, String errMsg) {
		super();
		this.id = id;
		this.portId = portId;
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.stockExchg = stockExchg;
		this.noOfShare = noOfShare;
		this.transPrice = transPrice;
		this.totalAmt = totalAmt;
		this.action = action;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.remarks = remarks;
		this.currentStockHold = currentStockHold;
		this.systemMsg = systemMsg;
		this.errMsg = errMsg;
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
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
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
	public BigDecimal getTransPrice() {
		return transPrice;
	}
	public void setTransPrice(BigDecimal transPrice) {
		this.transPrice = transPrice;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getCurrentStockHold() {
		return currentStockHold;
	}

	public void setCurrentStockHold(Integer currentStockHold) {
		this.currentStockHold = currentStockHold;
	}

	public String getSystemMsg() {
		return systemMsg;
	}

	public void setSystemMsg(String systemMsg) {
		this.systemMsg = systemMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}
