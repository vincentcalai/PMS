package com.pms.pmsapp.performance.service;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;

public interface PerformanceService {
  public ETFPerformance findEtfPerformance(String portfolio);
  public StockPerformance findStockPerformance(String portfolio);
}
