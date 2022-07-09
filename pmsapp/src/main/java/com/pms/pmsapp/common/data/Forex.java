package com.pms.pmsapp.common.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_FOREX")
@SequenceGenerator(name = "IdSeqGenerator", sequenceName = "SQ_PMS_FOREX", allocationSize = 1)
public class Forex {

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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdSeqGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FOREX_NAME", nullable = false, length = 50)
	public String getForexName() {
		return forexName;
	}

	public void setForexName(String forexName) {
		this.forexName = forexName;
	}

	@Column(name = "FOREX_SYM", unique = true, nullable = false, length = 10)
	public String getForexSymbol() {
		return forexSymbol;
	}

	public void setForexSymbol(String forexSymbol) {
		this.forexSymbol = forexSymbol;
	}

	@Column(name = "FOREX_DESC", nullable = false, length = 100)
	public String getForexDesc() {
		return forexDesc;
	}

	public void setForexDesc(String forexDesc) {
		this.forexDesc = forexDesc;
	}

	@Column(name = "LAST", nullable = false)
	public BigDecimal getLast() {
		return last;
	}

	public void setLast(BigDecimal last) {
		this.last = last;
	}

	@Column(name = "CHANGE", nullable = true)
	public BigDecimal getChange() {
		return change;
	}

	public void setChange(BigDecimal change) {
		this.change = change;
	}

	@Column(name = "CHANGE_PCT", nullable = true)
	public BigDecimal getChangePct() {
		return changePct;
	}

	public void setChangePct(BigDecimal changePct) {
		this.changePct = changePct;
	}

	@Column(name = "SUFFIX", nullable = true, length = 5)
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Column(name = "LAST_UPDATED_DT", nullable = true)
	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

}
