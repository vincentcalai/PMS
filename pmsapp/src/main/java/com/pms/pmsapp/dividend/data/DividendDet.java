package com.pms.pmsapp.dividend.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class DividendDet {

	private Long id;
	private Long divId;
	private Long portId;
	private String stockName;
	private String stockSym;
	private String stockExchg;
	private Date exDate;
	private	Integer noOfShare;
	private BigDecimal adjDiv;
	private BigDecimal divPayout;
	private BigDecimal sgdDivPayout;
	
	public DividendDet() {
		
	}

	public DividendDet(Long id, Long divId, Long portId, String stockName, String stockSym, String stockExchg,
			Date exDate, Integer noOfShare, BigDecimal adjDiv, BigDecimal divPayout, BigDecimal sgdDivPayout) {
		super();
		this.id = id;
		this.divId = divId;
		this.portId = portId;
		this.stockName = stockName;
		this.stockSym = stockSym;
		this.stockExchg = stockExchg;
		this.exDate = exDate;
		this.noOfShare = noOfShare;
		this.adjDiv = adjDiv;
		this.divPayout = divPayout;
		this.sgdDivPayout = sgdDivPayout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDivId() {
		return divId;
	}

	public void setDivId(Long divId) {
		this.divId = divId;
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

	public Date getExDate() {
		return exDate;
	}

	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}

	public Integer getNoOfShare() {
		return noOfShare;
	}

	public void setNoOfShare(Integer noOfShare) {
		this.noOfShare = noOfShare;
	}

	public BigDecimal getAdjDiv() {
		return adjDiv;
	}

	public void setAdjDiv(BigDecimal adjDiv) {
		this.adjDiv = adjDiv;
	}

	public BigDecimal getDivPayout() {
		return divPayout;
	}

	public void setDivPayout(BigDecimal divPayout) {
		this.divPayout = divPayout;
	}

	public BigDecimal getSgdDivPayout() {
		return sgdDivPayout;
	}

	public void setSgdDivPayout(BigDecimal sgdDivPayout) {
		this.sgdDivPayout = sgdDivPayout;
	}
	
	
	
	
}
