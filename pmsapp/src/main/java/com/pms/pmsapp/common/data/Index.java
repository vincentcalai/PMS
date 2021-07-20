package com.pms.pmsapp.common.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Index{
	
	private Long id;
	private String idxSym;
	private String idxName;
	private BigDecimal last;
	private BigDecimal change;
	private BigDecimal changePct;
	private Date lastUpdatedDt;

	public Index() {
	}
	
	public Index(Long id, String idxSym, String idxName, BigDecimal last, 
			BigDecimal change, BigDecimal changePct, Date lastUpdatedDt) {
		super();
		this.id = id;
		this.idxSym = idxSym;
		this.idxName = idxName;
		this.last = last;
		this.change = change;
		this.changePct = changePct;
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIdxSym() {
		return idxSym;
	}

	public void setIdxSym(String idxSym) {
		this.idxSym = idxSym;
	}

	public String getIdxName() {
		return idxName;
	}

	public void setIdxName(String idxName) {
		this.idxName = idxName;
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
	
	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

}
