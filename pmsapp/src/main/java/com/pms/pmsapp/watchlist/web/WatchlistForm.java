package com.pms.pmsapp.watchlist.web;

import java.util.Date;

public class WatchlistForm {

	private Long id;
	private String name;
	private String remarks;
	private String createdBy;
	private Date createdDt;
	private String lastMdfyBy;
	private Date lastMdfyDt;

	private String systemMsg;
	private String errMsg;

	public WatchlistForm() {
		super();
	}

	public WatchlistForm(Long id, String name, String remarks, String createdBy, Date createdDt, String lastMdfyBy,
			Date lastMdfyDt, String systemMsg, String errMsg) {
		super();
		this.id = id;
		this.name = name;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
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
