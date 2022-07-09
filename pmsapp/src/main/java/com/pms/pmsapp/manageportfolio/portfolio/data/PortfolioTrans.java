package com.pms.pmsapp.manageportfolio.portfolio.data;

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
@Table(name = "PMS_PORT_TRANS")
@SequenceGenerator(name = "IdSeqGenerator", sequenceName = "SQ_PMS_PORT_TRANS", allocationSize = 1)
public class PortfolioTrans {

	private Long id;
	private Long portId;
	private String stockName;
	private String stockSymbol;
	private String stockExchg;
	private Integer noOfShare;
	private BigDecimal transPrice;
	private BigDecimal totalAmt;
	private String action;
	private Date backDatedDate;
	private String createdBy;
	private Date createdDt;
	private String remarks;
	private Integer currentStockHold;
	private String systemMsg;
	private String errMsg;

	public PortfolioTrans() {
	}

	public PortfolioTrans(Long id, Long portId, String stockName, String stockSymbol, String stockExchg,
			Integer noOfShare, BigDecimal transPrice, BigDecimal totalAmt, String action, Date backDatedDate,
			String createdBy, Date createdDt, String remarks, Integer currentStockHold, String systemMsg,
			String errMsg) {
		super();
		this.id = id;
		this.portId = portId;
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.stockExchg = stockExchg;
		this.noOfShare = noOfShare;
		this.transPrice = transPrice;
		this.totalAmt = totalAmt;
		this.action = action;
		this.backDatedDate = backDatedDate;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.remarks = remarks;
		this.currentStockHold = currentStockHold;
		this.systemMsg = systemMsg;
		this.errMsg = errMsg;
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

	@Column(name = "PORT_ID", nullable = false)
	public Long getPortId() {
		return portId;
	}

	public void setPortId(Long portId) {
		this.portId = portId;
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
	public Integer getNoOfShare() {
		return noOfShare;
	}

	public void setNoOfShare(Integer noOfShare) {
		this.noOfShare = noOfShare;
	}

	@Column(name = "TRANS_PRICE", nullable = true)
	public BigDecimal getTransPrice() {
		return transPrice;
	}

	public void setTransPrice(BigDecimal transPrice) {
		this.transPrice = transPrice;
	}

	@Column(name = "TOTAL_AMT", nullable = true)
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Column(name = "ACTION", nullable = true, length = 4)
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getBackDatedDate() {
		return backDatedDate;
	}

	public void setBackDatedDate(Date backDatedDate) {
		this.backDatedDate = backDatedDate;
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

	public Integer getCurrentStockHold() {
		return currentStockHold;
	}

	public void setCurrentStockHold(Integer currentStockHold) {
		this.currentStockHold = currentStockHold;
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
