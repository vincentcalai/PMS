package com.pms.pmsapp.performance.data;

import java.math.BigDecimal;



public class ETFPerformance extends PortfolioPerformance{

  private final String name = "ETF";

  public ETFPerformance(BigDecimal investAmt, BigDecimal currentVal, BigDecimal profit, BigDecimal profitPct) {
    super(investAmt, currentVal, profit, profitPct);
  }

}
