package com.pms.pmsapp.performance.service;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;

import java.math.BigDecimal;

public interface PerformanceService {
  public ETFPerformance findEtfPerformance(String portfolio);
  public StockPerformance findStockPerformance(String portfolio);
  public GphyPerformance findGphyPerformance(String selectedPortfolio);
  public BigDecimal findUserBankBal(String username);
  public BigDecimal findUserTotalInvestment(String username);
  public String updateCashBal(int newCashBal, String username) throws Exception;
}
