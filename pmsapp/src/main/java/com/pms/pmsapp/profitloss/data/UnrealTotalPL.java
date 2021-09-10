package com.pms.pmsapp.profitloss.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class UnrealTotalPL implements Serializable{
	
	private Long portId;
	private String convertCurr;
	private BigDecimal totalAmt;
	private BigDecimal mktValue;
	private BigDecimal convProfitLoss;
	private BigDecimal profitLossPct;
	
	
	public UnrealTotalPL() {
	}

	public UnrealTotalPL(Long portId, String convertCurr, BigDecimal totalAmt, BigDecimal mktValue,
			BigDecimal convProfitLoss, BigDecimal profitLossPct) {
		super();
		this.portId = portId;
		this.convertCurr = convertCurr;
		this.totalAmt = totalAmt;
		this.mktValue = mktValue;
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


	public BigDecimal getTotalAmt() {
		return totalAmt;
	}


	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}


	public BigDecimal getMktValue() {
		return mktValue;
	}


	public void setMktValue(BigDecimal mktValue) {
		this.mktValue = mktValue;
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
