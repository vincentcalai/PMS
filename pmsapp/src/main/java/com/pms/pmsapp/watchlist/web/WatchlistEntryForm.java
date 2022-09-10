package com.pms.pmsapp.watchlist.web;

import java.math.BigDecimal;
import java.util.Date;

public class WatchlistEntryForm {

	private Long id;
	private Long watchId;
	private String stockName;
	private String stockSym;
	private String stockExchg;
	private BigDecimal lastPrice;
	private BigDecimal change;
	private BigDecimal changePct;
	private BigDecimal targetPrice;
	private BigDecimal premiumDisc;
	private String remarks;
	private String lastMdfyBy;
	private Date lastMdfyDt;

	private String systemMsg;
	private String errMsg;

	public WatchlistEntryForm() {
		super();
	}

	public WatchlistEntryForm(Long id, Long watchId, String stockName, String stockSym, String stockExchg,
			BigDecimal lastPrice, BigDecimal change, BigDecimal changePct, BigDecimal targetPrice,
			BigDecimal premiumDisc, String remarks, String lastMdfyBy, Date lastMdfyDt, String systemMsg,
			String errMsg) {
		super();
		this.id = id;
		this.watchId = watchId;
		this.stockName = stockName;
		this.stockSym = stockSym;
		this.stockExchg = stockExchg;
		this.lastPrice = lastPrice;
		this.change = change;
		this.changePct = changePct;
		this.targetPrice = targetPrice;
		this.premiumDisc = premiumDisc;
		this.remarks = remarks;
		this.lastMdfyBy = lastMdfyBy;
		this.lastMdfyDt = lastMdfyDt;
		this.systemMsg = systemMsg;
		this.errMsg = errMsg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWatchId() {
		return watchId;
	}

	public void setWatchId(Long watchId) {
		this.watchId = watchId;
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

	public BigDecimal getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
	}

	public BigDecimal getChange() {
		return change;
	}

	public void setChange(BigDecimal change) {
		this.change = change;
	}

	public BigDecimal getChangePct() {
		return changePct;
	}

	public void setChangePct(BigDecimal changePct) {
		this.changePct = changePct;
	}

	public BigDecimal getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(BigDecimal targetPrice) {
		this.targetPrice = targetPrice;
	}

	public BigDecimal getPremiumDisc() {
		return premiumDisc;
	}

	public void setPremiumDisc(BigDecimal premiumDisc) {
		this.premiumDisc = premiumDisc;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLastMdfyBy() {
		return lastMdfyBy;
	}

	public void setLastMdfyBy(String lastMdfyBy) {
		this.lastMdfyBy = lastMdfyBy;
	}

	public Date getLastMdfyDt() {
		return lastMdfyDt;
	}

	public void setLastMdfyDt(Date lastMdfyDt) {
		this.lastMdfyDt = lastMdfyDt;
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