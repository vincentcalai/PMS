package com.pms.pmsapp.profitloss.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_REAL_PL")
public class RealPL implements Serializable {

	private Long transId;
	private Long portId;
	private String stockName;
	private String stockSymbol;
	private String stockExchg;
	private String domCurr;
	private int totalShare;
	private Date sellDt;
	private BigDecimal avgCost;
	private BigDecimal sellPrice;
	private BigDecimal profitLoss;
	private BigDecimal convProfitLoss;
	private BigDecimal profitLossPct;

	public RealPL() {
		super();
	}

	public RealPL(Long transId, Long portId, String stockName, String stockSymbol, String stockExchg, String domCurr,
			int totalShare, Date sellDt, BigDecimal avgCost, BigDecimal sellPrice, BigDecimal profitLoss,
			BigDecimal convProfitLoss, BigDecimal profitLossPct) {
		super();
		this.transId = transId;
		this.portId = portId;
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.stockExchg = stockExchg;
		this.domCurr = domCurr;
		this.totalShare = totalShare;
		this.sellDt = sellDt;
		this.avgCost = avgCost;
		this.sellPrice = sellPrice;
		this.profitLoss = profitLoss;
		this.convProfitLoss = convProfitLoss;
		this.profitLossPct = profitLossPct;
	}

	@Id
	@Column(name = "TRANS_ID", unique = true, nullable = false)
	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
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

	@Column(name = "DOM_CURR", nullable = true)
	public String getDomCurr() {
		return domCurr;
	}

	public void setDomCurr(String domCurr) {
		this.domCurr = domCurr;
	}

	@Column(name = "TOTAL_SHARE", nullable = true)
	public int getTotalShare() {
		return totalShare;
	}

	public void setTotalShare(int totalShare) {
		this.totalShare = totalShare;
	}

	@Column(name = "SELL_DT", nullable = true)
	public Date getSellDt() {
		return sellDt;
	}

	public void setSellDt(Date sellDt) {
		this.sellDt = sellDt;
	}

	@Column(name = "AVG_COST", nullable = true)
	public BigDecimal getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(BigDecimal avgCost) {
		this.avgCost = avgCost;
	}

	@Column(name = "SELL_PRICE", nullable = true)
	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	@Column(name = "PROFIT_LOSS", nullable = true)
	public BigDecimal getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(BigDecimal profitLoss) {
		this.profitLoss = profitLoss;
	}

	@Column(name = "CONV_PROFIT_LOSS", nullable = true)
	public BigDecimal getConvProfitLoss() {
		return convProfitLoss;
	}

	public void setConvProfitLoss(BigDecimal convProfitLoss) {
		this.convProfitLoss = convProfitLoss;
	}

	@Column(name = "PROFIT_LOSS_PCT", nullable = true)
	public BigDecimal getProfitLossPct() {
		return profitLossPct;
	}

	public void setProfitLossPct(BigDecimal profitLossPct) {
		this.profitLossPct = profitLossPct;
	}

}
