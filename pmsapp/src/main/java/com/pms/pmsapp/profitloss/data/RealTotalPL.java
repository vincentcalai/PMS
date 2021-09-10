package com.pms.pmsapp.profitloss.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class RealTotalPL implements Serializable{
	
	private Long portId;
	private String convertCurr;
	private BigDecimal totalCost;
	private BigDecimal totalSoldAmt;
	private BigDecimal convProfitLoss;
	private BigDecimal profitLossPct;
	
	
	public RealTotalPL() {
	}


	public RealTotalPL(Long portId, String convertCurr, BigDecimal totalCost, BigDecimal totalSoldAmt,
			BigDecimal convProfitLoss, BigDecimal profitLossPct) {
		super();
		this.portId = portId;
		this.convertCurr = convertCurr;
		this.totalCost = totalCost;
		this.totalSoldAmt = totalSoldAmt;
		this.convProfitLoss = convProfitLoss;
		this.profitLossPct = profitLossPct;
	}

	public Long getPortId() {
		return portId;
	}


	public void setPortId(Long portId) {
		this.portId = portId;
	}


	public String getConvertCurr() {
		return convertCurr;
	}


	public void setConvertCurr(String convertCurr) {
		this.convertCurr = convertCurr;
	}


	public BigDecimal getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}


	public BigDecimal getTotalSoldAmt() {
		return totalSoldAmt;
	}


	public void setTotalSoldAmt(BigDecimal totalSoldAmt) {
		this.totalSoldAmt = totalSoldAmt;
	}


	public BigDecimal getConvProfitLoss() {
		return convProfitLoss;
	}


	public void setConvProfitLoss(BigDecimal convProfitLoss) {
		this.convProfitLoss = convProfitLoss;
	}


	public BigDecimal getProfitLossPct() {
		return profitLossPct;
	}


	public void setProfitLossPct(BigDecimal profitLossPct) {
		this.profitLossPct = profitLossPct;
	}

}
