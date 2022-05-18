package com.pms.pmsapp.performance.service;

import com.pms.pmsapp.performance.dao.PerformanceDao;
import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceServiceImpl implements PerformanceService{

  @Autowired
  private PerformanceDao performanceDao;

  public ETFPerformance findEtfPerformance(String portfolio){
    return performanceDao.findEtfPerformance(portfolio);
  }

  public StockPerformance findStockPerformance(String portfolio){
    return performanceDao.findStockPerformance(portfolio);
  }
}
