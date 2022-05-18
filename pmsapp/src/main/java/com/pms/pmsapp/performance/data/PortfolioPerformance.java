package com.pms.pmsapp.performance.data;

import java.math.BigDecimal;

public class PortfolioPerformance {
  private String name;
  private BigDecimal investAmt;
  private BigDecimal currentVal;
  private BigDecimal profit;
  private BigDecimal profitPct;

  public PortfolioPerformance() {
  }

  public PortfolioPerformance(BigDecimal investAmt, BigDecimal currentVal, BigDecimal profit, BigDecimal profitPct) {
    this.investAmt = investAmt;
    this.currentVal = currentVal;
    this.profit = profit;
    this.profitPct = profitPct;
  }

  public PortfolioPerformance(String name, BigDecimal investAmt, BigDecimal currentVal, BigDecimal profit, BigDecimal profitPct) {
    this.name = name;
    this.investAmt = investAmt;
    this.currentVal = currentVal;
    this.profit = profit;
    this.profitPct = profitPct;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getInvestAmt() {
    return investAmt;
  }

  public BigDecimal getCurrentVal() {
    return currentVal;
  }

  public BigDecimal getProfit() {
    return profit;
  }

  public BigDecimal getProfitPct() {
    return profitPct;
  }
}
