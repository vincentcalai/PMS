package com.pms.pmsapp.dataloading.data;

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
@Table(name = "PMS_LOAD_PORT_TRANS")
@SequenceGenerator(name = "LoadPortTransSeqGenerator", sequenceName = "SQ_PMS_LOAD_PORT_TRANS", allocationSize = 1)
public class LoadPortfolioTrans {

	private Long id;
	private Long uploadId;
	private String stockName;
	private String stockSymbol;
	private String stockExchg;
	private int noOfShare;
	private BigDecimal transPrice;
	private String action;
	private String createdBy;
	private Date createdDt;
	private String remarks;

	public LoadPortfolioTrans() {
	}

	public LoadPortfolioTrans(Long id, Long uploadId, String stockName, String stockSymbol, String stockExchg,
			int noOfShare, BigDecimal transPrice, String action, String createdBy, Date createdDt, String remarks) {
		super();
		this.id = id;
		this.uploadId = uploadId;
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.stockExchg = stockExchg;
		this.noOfShare = noOfShare;
		this.transPrice = transPrice;
		this.action = action;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.remarks = remarks;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LoadPortTransSeqGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "UPLOAD_ID", nullable = false)
	public Long getUploadId() {
		return uploadId;
	}

	public void setUploadId(Long uploadId) {
		this.uploadId = uploadId;
	}

	@Column(name = "STOCK_NAM", nullable = false, length = 100)
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Column(name = "STOCK_SYM", nullable = false, length = 10)
	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	@Column(name = "STOCK_EXCHG", nullable = true, length = 6)
	public String getStockExchg() {
		return stockExchg;
	}

	public void setStockExchg(String stockExchg) {
		this.stockExchg = stockExchg;
	}

	@Column(name = "NO_OF_SHARE", nullable = true)
	public int getNoOfShare() {
		return noOfShare;
	}

	public void setNoOfShare(int noOfShare) {
		this.noOfShare = noOfShare;
	}

	@Column(name = "TRANS_PRICE", nullable = true)
	public BigDecimal getTransPrice() {
		return transPrice;
	}

	public void setTransPrice(BigDecimal transPrice) {
		this.transPrice = transPrice;
	}

	@Column(name = "ACTION", nullable = true, length = 4)
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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

	@Column(name = "REMARKS", nullable = true, length = 100)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
