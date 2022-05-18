package com.pms.pmsapp.performance.data;

import java.math.BigDecimal;



public class ETFPerformance extends PortfolioPerformance{

  public static final String etfName = "ETF";

  public ETFPerformance(String name, BigDecimal investAmt, BigDecimal currentVal, BigDecimal profit, BigDecimal profitPct) {
    super(name, investAmt, currentVal, profit, profitPct);
  }

}
