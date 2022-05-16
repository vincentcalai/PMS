package com.pms.pmsapp.performance.web;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.PortfolioPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;

import java.util.List;

public class PerformanceForm {

  private List<String> portfolioList;
  private String selectedPortfolio;
  private PortfolioPerformance portfolioPerformance;
  private ETFPerformance etfPerformance;
  private StockPerformance stockPerformance;
  private String errMsg;

  public List<String> getPortfolioList() {
    return portfolioList;
  }

  public void setPortfolioList(List<String> portfolioList) {
    this.portfolioList = portfolioList;
  }

  public String getSelectedPortfolio() {
    return selectedPortfolio;
  }

  public void setSelectedPortfolio(String selectedPortfolio) {
    this.selectedPortfolio = selectedPortfolio;
  }

  public PortfolioPerformance getPortfolioPerformance() {
    return portfolioPerformance;
  }

  public void setPortfolioPerformance(PortfolioPerformance portfolioPerformance) {
    this.portfolioPerformance = portfolioPerformance;
  }

  public ETFPerformance getEtfPerformance() {
    return etfPerformance;
  }

  public void setEtfPerformance(ETFPerformance etfPerformance) {
    this.etfPerformance = etfPerformance;
  }

  public StockPerformance getStockPerformance() {
    return stockPerformance;
  }

  public void setStockPerformance(StockPerformance stockPerformance) {
    this.stockPerformance = stockPerformance;
  }

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }
}
