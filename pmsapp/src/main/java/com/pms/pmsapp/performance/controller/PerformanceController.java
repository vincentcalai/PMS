package com.pms.pmsapp.performance.controller;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.PortfolioPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import com.pms.pmsapp.performance.web.PerformanceForm;
import com.pms.pmsapp.profitloss.service.ProfitLossService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PerformanceController {

  @Autowired
  ProfitLossService profitLossService;

  private static final Logger log = LoggerFactory.getLogger(PerformanceController.class);

  @RequestMapping(value="/performance/init", method= RequestMethod.POST)
  public PerformanceForm init(@RequestBody PerformanceForm performanceForm) {
    log.info("performance init in Controller");
    List<String> portfolios = profitLossService.getPortfolios();
    performanceForm.setPortfolioList(portfolios);
    return performanceForm;
  }

  @RequestMapping(value="/performance/loadPerfTab", method= RequestMethod.POST)
  public PerformanceForm loadPerfTab(@RequestBody PerformanceForm performanceForm) {
    log.info("performance loadPerfTab in Controller");
    PortfolioPerformance portfolioPerformance = new PortfolioPerformance(new BigDecimal(1000.0), new BigDecimal(1000.0), new BigDecimal(100.0), new BigDecimal(10.0));
    ETFPerformance etfPerformance = new ETFPerformance(new BigDecimal(2000.0), new BigDecimal(3000.0), new BigDecimal(1000), new BigDecimal(20.0));
    StockPerformance stockPerformance = new StockPerformance(new BigDecimal(6000.0), new BigDecimal(10000.0), new BigDecimal(4000.0), new BigDecimal(40.0));

    performanceForm.setPortfolioPerformance(portfolioPerformance);
    performanceForm.setEtfPerformance(etfPerformance);
    performanceForm.setStockPerformance(stockPerformance);
    return performanceForm;
  }


}
