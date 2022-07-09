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
@Table(name = "PMS_INDEX")
@SequenceGenerator(name = "IdSeqGenerator", sequenceName = "SQ_PMS_INDEX", allocationSize = 1)
public class Index {

	private Long id;
	private String idxSym;
	private String idxName;
	private BigDecimal last;
	private BigDecimal change;
	private BigDecimal changePct;
	private Date lastUpdatedDt;

	public Index() {
	}

	public Index(Long id, String idxSym, String idxName, BigDecimal last, BigDecimal change, BigDecimal changePct,
			Date lastUpdatedDt) {
		super();
		this.id = id;
		this.idxSym = idxSym;
		this.idxName = idxName;
		this.last = last;
		this.change = change;
		this.changePct = changePct;
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

	@Column(name = "INDEX_SYM", unique = true, nullable = false, length = 10)
	public String getIdxSym() {
		return idxSym;
	}

	public void setIdxSym(String idxSym) {
		this.idxSym = idxSym;
	}

	@Column(name = "INDEX_NAME", nullable = false, length = 50)
	public String getIdxName() {
		return idxName;
	}

	public void setIdxName(String idxName) {
		this.idxName = idxName;
	}

	@Column(name = "LAST", nullable = true)
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

	@Column(name = "LAST_UPDATED_DT", nullable = true)
	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

}
