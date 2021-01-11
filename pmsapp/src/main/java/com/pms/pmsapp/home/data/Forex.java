package com.pms.pmsapp.home.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Forex{
	
	private Long id;
	private String forexName;
	private String forexSymbol;
	private String forexDesc;
	private BigDecimal last;
	private BigDecimal change;
	private BigDecimal changePct;
	private String suffix;
	private Date lastUpdatedDt;

	public Forex() {
	}
	
	public Forex(Long id, String forexName, String forexSymbol, String forexDesc, BigDecimal last, BigDecimal change,
			BigDecimal changePct, String suffix, Date lastUpdatedDt) {
		super();
		this.id = id;
		this.forexName = forexName;
		this.forexSymbol = forexSymbol;
		this.forexDesc = forexDesc;
		this.last = last;
		this.change = change;
		this.changePct = changePct;
		this.suffix = suffix;
		this.lastUpdatedDt = lastUpdatedDt;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForexName() {
		return forexName;
	}

	public void setForexName(String forexName) {
		this.forexName = forexName;
	}

	public String getForexSymbol() {
		return forexSymbol;
	}

	public void setForexSymbol(String forexSymbol) {
		this.forexSymbol = forexSymbol;
	}

	public String getForexDesc() {
		return forexDesc;
	}

	public void setForexDesc(String forexDesc) {
		this.forexDesc = forexDesc;
	}

	public BigDecimal getLast() {
		return last;
	}

	public void setLast(BigDecimal last) {
		this.last = last;
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

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	
}
