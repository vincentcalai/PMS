package com.pms.pmsapp.performance.controller;

import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioService;
import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.PortfolioPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import com.pms.pmsapp.performance.service.PerformanceService;
import com.pms.pmsapp.performance.web.PerformanceForm;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;
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

  private final String convCurrency = "SGD";


  @Autowired
  private ProfitLossService profitLossService;

  @Autowired
  private PortfolioService portfolioService;

  @Autowired
  private PerformanceService performanceService;

  PortfolioPerformance portfolioPerformance;
  ETFPerformance etfPerformance;
  StockPerformance stockPerformance;

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

    String selectedPortfolio = performanceForm.getSelectedPortfolio();
    long portId = portfolioService.getPortIdFromPortName(selectedPortfolio);

    profitLossService.computeUnrealisedList(selectedPortfolio, convCurrency);
    UnrealTotalPL unrealTotalPlList = profitLossService.getUnrealisedTotalList(selectedPortfolio);

    if(unrealTotalPlList != null){
      portfolioPerformance = new PortfolioPerformance(unrealTotalPlList.getTotalAmt(), unrealTotalPlList.getMktValue(), unrealTotalPlList.getConvProfitLoss(), unrealTotalPlList.getProfitLossPct());
      etfPerformance = performanceService.findEtfPerformance(selectedPortfolio);
      stockPerformance = performanceService.findStockPerformance(selectedPortfolio);
    } else {
      portfolioPerformance = new PortfolioPerformance(new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
      etfPerformance = new ETFPerformance(ETFPerformance.etfName, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
      stockPerformance = new StockPerformance(StockPerformance.stockName, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
    }

    performanceForm.setPortfolioPerformance(portfolioPerformance);
    performanceForm.setEtfPerformance(etfPerformance);
    performanceForm.setStockPerformance(stockPerformance);
    return performanceForm;
  }

}
