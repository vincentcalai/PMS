package com.pms.pmsapp.manageportfolio.portfolio.data;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Portfolio{
	
	public Portfolio() {
	}

	public Portfolio(Long id) {
		this.id = id;
	}

//@GeneratedValue(strategy = GenerationType.SEQUENCE), generator = "generator")
//	@SequenceGenerator(name = "generator", sequenceName = "SQ_PMS_PORT", allocationSize = 1)
	private Long id;
	private String portfolioName;
	private String createdBy;
	private Date createdDate;
	private	String lastMdfyBy;
	private Date lastMdfyDt;
	private String remarks;
	private String errMsg;
	private String systemMsg;

	public Portfolio(Long id, String portfolioName, String createdBy, Date createdDate, String lastMdfyBy,
			Date lastMdfyDt, String remarks, String errMsg, String systemMsg) {
		super();
		this.id = id;
		this.portfolioName = portfolioName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastMdfyBy = lastMdfyBy;
		this.lastMdfyDt = lastMdfyDt;
		this.remarks = remarks;
		this.errMsg = errMsg;
		this.systemMsg = systemMsg;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String getSystemMsg() {
		return systemMsg;
	}

	public void setSystemMsg(String systemMsg) {
		this.systemMsg = systemMsg;
	}
}
