package com.pms.pmsapp.manageportfolio.portfolio.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PortfolioHold implements Serializable{
	
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
	
	public PortfolioHold(Long portId, String stockName, String stockSymbol, String stockExchg,
			int totalShare, BigDecimal avgPrice, BigDecimal totalAmt, BigDecimal lastTransPrice, BigDecimal mktValue,
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
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		return true;
	}

	public Long getPortId() {
		return portId;
	}

	public void setPortId(Long portId) {
		this.portId = portId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getStockExchg() {
		return stockExchg;
	}

	public void setStockExchg(String stockExchg) {
		this.stockExchg = stockExchg;
	}

	public int getTotalShare() {
		return totalShare;
	}

	public void setTotalShare(int totalShare) {
		this.totalShare = totalShare;
	}

	public BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	public BigDecimal getLastTransPrice() {
		return lastTransPrice;
	}

	public void setLastTransPrice(BigDecimal lastTransPrice) {
		this.lastTransPrice = lastTransPrice;
	}

	public BigDecimal getMktValue() {
		return mktValue;
	}

	public void setMktValue(BigDecimal mktValue) {
		this.mktValue = mktValue;
	}

	public BigDecimal getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(BigDecimal profitLoss) {
		this.profitLoss = profitLoss;
	}

	public BigDecimal getProfitLossPct() {
		return profitLossPct;
	}

	public void setProfitLossPct(BigDecimal profitLossPct) {
		this.profitLossPct = profitLossPct;
	}

	public String getLastTransBy() {
		return lastTransBy;
	}

	public void setLastTransBy(String lastTransBy) {
		this.lastTransBy = lastTransBy;
	}

	public Date getLastTransDt() {
		return lastTransDt;
	}

	public void setLastTransDt(Date lastTransDt) {
		this.lastTransDt = lastTransDt;
	}

}
