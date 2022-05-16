package com.pms.pmsapp.performance.data;

import java.math.BigDecimal;

public class StockPerformance extends PortfolioPerformance {
  private final String name = "Stock Equity";

  public StockPerformance(BigDecimal investAmt, BigDecimal currentVal, BigDecimal profit, BigDecimal profitPct) {
    super(investAmt, currentVal, profit, profitPct);
  }
}
