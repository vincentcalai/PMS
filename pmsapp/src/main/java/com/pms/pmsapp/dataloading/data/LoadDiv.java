package com.pms.pmsapp.dataloading.data;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class LoadDiv{
	
	private Long id;
	private Long uploadId;
	private String stockName;
	private String stockSym;
	private String stockExchg;
	private	Integer noOfShare;
	private Date datePurchase;
	private Date dateSold;
	private String currHoldInd;
	private String createdBy;
	
	public LoadDiv() {
	}

	public LoadDiv(Long id, Long uploadId, String stockName, String stockSym, String stockExchg,
			Integer noOfShare, Date datePurchase, Date dateSold, String currHoldInd, String createdBy) {
		super();
		this.id = id;
		this.uploadId = uploadId;
		this.stockName = stockName;
		this.stockSym = stockSym;
		this.stockExchg = stockExchg;
		this.noOfShare = noOfShare;
		this.datePurchase = datePurchase;
		this.dateSold = dateSold;
		this.currHoldInd = currHoldInd;
		this.createdBy = createdBy;
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


	public String getCurrHoldInd() {
		return currHoldInd;
	}


	public void setCurrHoldInd(String currHoldInd) {
		this.currHoldInd = currHoldInd;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	

}