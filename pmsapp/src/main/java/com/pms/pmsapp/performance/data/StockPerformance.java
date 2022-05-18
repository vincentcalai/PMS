package com.pms.pmsapp.performance.data;

import java.math.BigDecimal;

public class StockPerformance extends PortfolioPerformance {

  public static final String stockName = "Stock Equity";
  public StockPerformance(String name, BigDecimal investAmt, BigDecimal currentVal, BigDecimal profit, BigDecimal profitPct) {
    super(name, investAmt, currentVal, profit, profitPct);
  }
}
