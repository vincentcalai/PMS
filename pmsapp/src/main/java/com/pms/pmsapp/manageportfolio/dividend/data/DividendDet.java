package com.pms.pmsapp.manageportfolio.dividend.data;

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
@Table(name = "PMS_PORT_DIV_DET")
@SequenceGenerator(name = "PortDivDetSeqGenerator", sequenceName = "SQ_PMS_PORT_DIV_DET", allocationSize = 1)
public class DividendDet {

	private Long id;
	private Long divId;
	private Long portId;
	private String stockName;
	private String stockSym;
	private String stockExchg;
	private Date exDate;
	private Integer noOfShare;
	private BigDecimal adjDiv;
	private BigDecimal divPayout;
	private BigDecimal sgdDivPayout;

	public DividendDet() {

	}

	public DividendDet(Long id, Long divId, Long portId, String stockName, String stockSym, String stockExchg,
			Date exDate, Integer noOfShare, BigDecimal adjDiv, BigDecimal divPayout, BigDecimal sgdDivPayout) {
		super();
		this.id = id;
		this.divId = divId;
		this.portId = portId;
		this.stockName = stockName;
		this.stockSym = stockSym;
		this.stockExchg = stockExchg;
		this.exDate = exDate;
		this.noOfShare = noOfShare;
		this.adjDiv = adjDiv;
		this.divPayout = divPayout;
		this.sgdDivPayout = sgdDivPayout;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PortDivDetSeqGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "DIV_ID", nullable = false)
	public Long getDivId() {
		return divId;
	}

	public void setDivId(Long divId) {
		this.divId = divId;
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

	@Column(name = "EX_DATE", nullable = true)
	public Date getExDate() {
		return exDate;
	}

	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}

	@Column(name = "NO_OF_SHARE", nullable = true)
	public Integer getNoOfShare() {
		return noOfShare;
	}

	public void setNoOfShare(Integer noOfShare) {
		this.noOfShare = noOfShare;
	}

	@Column(name = "ADJ_DIV", nullable = true)
	public BigDecimal getAdjDiv() {
		return adjDiv;
	}

	public void setAdjDiv(BigDecimal adjDiv) {
		this.adjDiv = adjDiv;
	}

	@Column(name = "DIV_PAYOUT", nullable = true)
	public BigDecimal getDivPayout() {
		return divPayout;
	}

	public void setDivPayout(BigDecimal divPayout) {
		this.divPayout = divPayout;
	}

	@Column(name = "SGD_DIV_PAYOUT", nullable = true)
	public BigDecimal getSgdDivPayout() {
		return sgdDivPayout;
	}

	public void setSgdDivPayout(BigDecimal sgdDivPayout) {
		this.sgdDivPayout = sgdDivPayout;
	}

}
