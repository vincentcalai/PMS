package com.pms.pmsapp.performance.web;

import java.util.List;

public class PerformanceForm {

  private List<String> portfolioList;
  private String selectedPortfolio;
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

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }
}
