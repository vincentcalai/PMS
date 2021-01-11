package com.pms.pmsapp.loadportfolio.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class LoadPortfolioTrans{
	
	private Long id;
	private Long uploadId;
	private String stockName;
	private String stockSymbol;
	private String stockExchg;
	private int noOfShare;
	private BigDecimal transPrice;
	private String action;
	private String createdBy;
	private Date createdDt;
	private String remarks;

	public LoadPortfolioTrans() {
	}

	public LoadPortfolioTrans(Long id, Long uploadId, String stockName, String stockSymbol, String stockExchg, int noOfShare,
			BigDecimal transPrice, String action, String createdBy, Date createdDt,
			String remarks) {
		super();
		this.id = id;
		this.uploadId = uploadId;
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.stockExchg = stockExchg;
		this.noOfShare = noOfShare;
		this.transPrice = transPrice;
		this.action = action;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.remarks = remarks;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUploadId() {
		return uploadId;
	}

	public void setUploadId(Long uploadId) {
		this.uploadId = uploadId;
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

	public int getNoOfShare() {
		return noOfShare;
	}

	public void setNoOfShare(int noOfShare) {
		this.noOfShare = noOfShare;
	}

	public BigDecimal getTransPrice() {
		return transPrice;
	}

	public void setTransPrice(BigDecimal transPrice) {
		this.transPrice = transPrice;
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

}
