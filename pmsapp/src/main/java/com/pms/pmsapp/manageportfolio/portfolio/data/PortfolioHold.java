package com.pms.pmsapp.manageportfolio.portfolio.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_PORT_HOLD")
public class PortfolioHold implements Serializable {

	private Long portId;
	private String stockName;
	private String stockSymbol;
	private String stockExchg;
	private int totalShare;
	private BigDecimal avgPrice;
	private BigDecimal totalAmt;
	private BigDecimal lastTransPrice;
	private BigDecimal mktValue;
	private BigDecimal profitLoss;
	private BigDecimal profitLossPct;
	private String lastTransBy;
	private Date lastTransDt;

	public PortfolioHold() {
	}

	public PortfolioHold(Long portId, String stockName, String stockSymbol, String stockExchg, int totalShare,
			BigDecimal avgPrice, BigDecimal totalAmt, BigDecimal lastTransPrice, BigDecimal mktValue,
			BigDecimal profitLoss, BigDecimal profitLossPct, String lastTransBy, Date lastTransDt) {
		super();
		this.portId = portId;
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.stockExchg = stockExchg;
		this.totalShare = totalShare;
		this.avgPrice = avgPrice;
		this.totalAmt = totalAmt;
		this.lastTransPrice = lastTransPrice;
		this.mktValue = mktValue;
		this.profitLoss = profitLoss;
		this.profitLossPct = profitLossPct;
		this.lastTransBy = lastTransBy;
		this.lastTransDt = lastTransDt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((portId == null) ? 0 : portId.hashCode());
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortfolioHold other = (PortfolioHold) obj;
		if (portId == null) {
			if (other.portId != null)
				return false;
		} else if (!portId.equals(other.portId))
			return false;
		if (stockName == null) {
			return other.stockName == null;
		} else
			return stockName.equals(other.stockName);
	}

	@Column(name = "PORT_ID", unique = true, nullable = false)
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

	@Column(name = "TOTAL_SHARE", nullable = true)
	public int getTotalShare() {
		return totalShare;
	}

	public void setTotalShare(int totalShare) {
		this.totalShare = totalShare;
	}

	@Column(name = "AVG_PRICE", nullable = true)
	public BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

	@Column(name = "TOTAL_AMT", nullable = true)
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Column(name = "LAST_TRANS_PRICE", nullable = true)
	public BigDecimal getLastTransPrice() {
		return lastTransPrice;
	}

	public void setLastTransPrice(BigDecimal lastTransPrice) {
		this.lastTransPrice = lastTransPrice;
	}

	@Column(name = "MKT_VALUE", nullable = true)
	public BigDecimal getMktValue() {
		return mktValue;
	}

	public void setMktValue(BigDecimal mktValue) {
		this.mktValue = mktValue;
	}

	@Column(name = "PROFIT_LOSS", nullable = true)
	public BigDecimal getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(BigDecimal profitLoss) {
		this.profitLoss = profitLoss;
	}

	@Column(name = "PROFIT_LOSS_PCT", nullable = true)
	public BigDecimal getProfitLossPct() {
		return profitLossPct;
	}

	public void setProfitLossPct(BigDecimal profitLossPct) {
		this.profitLossPct = profitLossPct;
	}

	@Column(name = "LAST_TRANS_BY", nullable = true, length = 20)
	public String getLastTransBy() {
		return lastTransBy;
	}

	public void setLastTransBy(String lastTransBy) {
		this.lastTransBy = lastTransBy;
	}

	@Column(name = "LAST_TRANS_DT", nullable = true)
	public Date getLastTransDt() {
		return lastTransDt;
	}

	public void setLastTransDt(Date lastTransDt) {
		this.lastTransDt = lastTransDt;
	}

}
