package com.pms.pmsapp.performance.service;

import com.pms.pmsapp.performance.dao.PerformanceDao;
import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PerformanceServiceImpl implements PerformanceService{

  @Autowired
  private PerformanceDao performanceDao;

  @Override
  public ETFPerformance findEtfPerformance(String portfolio){
    return performanceDao.findEtfPerformance(portfolio);
  }

  @Override
  public StockPerformance findStockPerformance(String portfolio){
    return performanceDao.findStockPerformance(portfolio);
  }

  @Override
  public GphyPerformance findGphyPerformance(String selectedPortfolio){
    return performanceDao.findGphyPerformance(selectedPortfolio);
  }

  @Override
  public BigDecimal findUserBankBal(String username) {
    return performanceDao.findUserBankBal(username);
  }

  @Override
  public BigDecimal findUserTotalInvestment(String username) {
    return performanceDao.findUserTotalInvestment(username);
  }
}
