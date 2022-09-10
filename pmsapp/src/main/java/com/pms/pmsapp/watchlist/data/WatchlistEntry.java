package com.pms.pmsapp.watchlist.data;

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
@Table(name = "PMS_WATCHLIST_ENTRY")
@SequenceGenerator(name = "WatchListEntrySeqGenerator", sequenceName = "SQ_PMS_WATCHLIST_ENTRY", allocationSize = 1)
public class WatchlistEntry {

	private Long id;
	private Long watchId;
	private String stockName;
	private String stockSym;
	private String stockExchg;
	private BigDecimal lastPrice;
	private BigDecimal change;
	private BigDecimal changePct;
	private BigDecimal targetPrice;
	private BigDecimal premiumDisc;
	private String remarks;
	private String lastMdfyBy;
	private Date lastMdfyDt;

	public WatchlistEntry() {
		super();
	}

	public WatchlistEntry(Long id, Long watchId, String stockName, String stockSym, String stockExchg,
			BigDecimal lastPrice, BigDecimal change, BigDecimal changePct, BigDecimal targetPrice,
			BigDecimal premiumDisc, String remarks, String lastMdfyBy, Date lastMdfyDt) {
		super();
		this.id = id;
		this.watchId = watchId;
		this.stockName = stockName;
		this.stockSym = stockSym;
		this.stockExchg = stockExchg;
		this.lastPrice = lastPrice;
		this.change = change;
		this.changePct = changePct;
		this.targetPrice = targetPrice;
		this.premiumDisc = premiumDisc;
		this.remarks = remarks;
		this.lastMdfyBy = lastMdfyBy;
		this.lastMdfyDt = lastMdfyDt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WatchListEntrySeqGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public Long getWatchId() {
		return watchId;
	}

	public void setWatchId(Long watchId) {
		this.watchId = watchId;
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

	@Column(name = "LAST_PRICE", nullable = true)
	public BigDecimal getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
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

	@Column(name = "TARGET_PRICE", nullable = true)
	public BigDecimal getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(BigDecimal targetPrice) {
		this.targetPrice = targetPrice;
	}

	@Column(name = "PREMIUM_DISC", nullable = true)
	public BigDecimal getPremiumDisc() {
		return premiumDisc;
	}

	public void setPremiumDisc(BigDecimal premiumDisc) {
		this.premiumDisc = premiumDisc;
	}

	@Column(name = "REMARKS", nullable = true, length = 100)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "LAST_MDFY_BY", nullable = true, length = 25)
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
