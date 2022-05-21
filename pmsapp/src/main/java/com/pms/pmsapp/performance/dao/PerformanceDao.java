package com.pms.pmsapp.performance.dao;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;

public interface PerformanceDao {
  public ETFPerformance findEtfPerformance(String portfolio);
  public StockPerformance findStockPerformance(String portfolio);

  public GphyPerformance findGphyPerformance(String selectedPortfolio);
}
