package com.pms.pmsapp.performance.service;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;

import java.math.BigDecimal;

public interface PerformanceService {
  public ETFPerformance findEtfPerformance(String portfolio);
  public StockPerformance findStockPerformance(String portfolio);
  public GphyPerformance findGphyPerformance(String selectedPortfolio);

  BigDecimal findUserBankBal(String username);

  BigDecimal findUserTotalInvestment(String username);
}
