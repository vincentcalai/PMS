package com.pms.pmsapp.watchlist.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_WATCHLIST")
@SequenceGenerator(name = "WatchListSeqGenerator", sequenceName = "SQ_PMS_WATCHLIST", allocationSize = 1)
public class Watchlist {

	private Long id;
	private String name;
	private String remarks;
	private String createdBy;
	private Date createdDt;
	private String lastMdfyBy;
	private Date lastMdfyDt;

	public Watchlist() {
		super();
	}

	public Watchlist(Long id, String name, String remarks, String createdBy, Date createdDt, String lastMdfyBy,
			Date lastMdfyDt) {
		super();
		this.id = id;
		this.name = name;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.lastMdfyBy = lastMdfyBy;
		this.lastMdfyDt = lastMdfyDt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WatchListSeqGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "REMARKS", nullable = true, length = 100)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "CREATED_BY", nullable = true, length = 20)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DT", nullable = true)
	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	@Column(name = "LAST_MDFY_BY", nullable = true, length = 20)
	public String getLastMdfyBy() {
		return lastMdfyBy;
	}

	public void setLastMdfyBy(String lastMdfyBy) {
		this.lastMdfyBy = lastMdfyBy;
	}

	@Column(name = "LAST_MDFY_DT", nullable = true)
	public Date getLastMdfyDt() {
		return lastMdfyDt;
	}

	public void setLastMdfyDt(Date lastMdfyDt) {
		this.lastMdfyDt = lastMdfyDt;
	}

}
