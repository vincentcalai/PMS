package com.pms.pmsapp.manageportfolio.portfolio.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_PORT")
@SequenceGenerator(name = "PortSeqGenerator", sequenceName = "SQ_PMS_PORT", allocationSize = 1)
public class Portfolio {

	public Portfolio() {
	}

	public Portfolio(Long id) {
		this.id = id;
	}

	private Long id;
	private String portfolioName;
	private String createdBy;
	private Date createdDate;
	private String lastMdfyBy;
	private Date lastMdfyDt;
	private String remarks;

	public Portfolio(Long id, String portfolioName, String createdBy, Date createdDate, String lastMdfyBy,
			Date lastMdfyDt, String remarks) {
		super();
		this.id = id;
		this.portfolioName = portfolioName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastMdfyBy = lastMdfyBy;
		this.lastMdfyDt = lastMdfyDt;
		this.remarks = remarks;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PortSeqGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PORT_NAME", nullable = false, length = 25)
	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	@Column(name = "CREATED_BY", nullable = true, length = 20)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DT", nullable = true)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	@Column(name = "REMARKS", nullable = true, length = 100)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
