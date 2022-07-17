package com.pms.pmsapp.manageportfolio.dividend.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_PORT_DIV")
@SequenceGenerator(name = "PortDivSeqGenerator", sequenceName = "SQ_PMS_PORT_DIV", allocationSize = 1)
public class Dividend {

	private Long id;
	private Long portId;
	private String stockName;
	private String stockSym;
	private String stockExchg;
	private Integer noOfShare;
	private Date datePurchase;
	private Date dateSold;
	private String currHoldInd;
	private String createdBy;

	public Dividend() {

	}

	public Dividend(Long id, Long portId, String stockName, String stockSym, String stockExchg, Integer noOfShare,
			Date datePurchase, Date dateSold, String currHoldInd, String createdBy) {
		super();
		this.id = id;
		this.portId = portId;
		this.stockName = stockName;
		this.stockSym = stockSym;
		this.stockExchg = stockExchg;
		this.noOfShare = noOfShare;
		this.datePurchase = datePurchase;
		this.dateSold = dateSold;
		this.currHoldInd = currHoldInd;
		this.createdBy = createdBy;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PortDivSeqGenerator")
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
	public String getStockSym() {
		return stockSym;
	}

	public void setStockSym(String stockSym) {
		this.stockSym = stockSym;
	}

	@Column(name = "STOCK_EXCHG", nullable = true, length = 6)
	public String getStockExchg() {
		return stockExchg;
	}

	public void setStockExchg(String stockExchg) {
		this.stockExchg = stockExchg;
	}

	@Column(name = "NO_OF_SHARE", nullable = false)
	public Integer getNoOfShare() {
		return noOfShare;
	}

	public void setNoOfShare(Integer noOfShare) {
		this.noOfShare = noOfShare;
	}

	@Column(name = "DATE_PURCHASE", nullable = false)
	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	@Column(name = "DATE_SOLD", nullable = true)
	public Date getDateSold() {
		return dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}

	@Column(name = "CURR_HOLD_IND", nullable = true, length = 1)
	public String getCurrHoldInd() {
		return currHoldInd;
	}

	public void setCurrHoldInd(String currHoldInd) {
		this.currHoldInd = currHoldInd;
	}

	@Column(name = "CREATED_BY", nullable = true, length = 20)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
