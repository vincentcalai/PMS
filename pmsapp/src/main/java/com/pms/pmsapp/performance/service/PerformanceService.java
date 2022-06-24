package com.pms.pmsapp.performance.service;

import java.math.BigDecimal;
import java.util.Map;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import com.pms.pmsapp.performance.web.PerformanceForm;

public interface PerformanceService {
	public ETFPerformance findEtfPerformance(String portfolio);

	public StockPerformance findStockPerformance(String portfolio);

	public GphyPerformance findGphyPerformance(String selectedPortfolio);

	public BigDecimal findUserBankBal(String username);

	public BigDecimal findUserOtherAsset(String username);

	public BigDecimal findUserTotalInvestment(String username);

	public String updateCashBal(BigDecimal newCashBal, String username);

	public String updateOtherAsset(BigDecimal newOtherAsset, String username);

	public PerformanceForm initPage(PerformanceForm performanceForm);

	public PerformanceForm loadInvest(PerformanceForm performanceForm);

	public PerformanceForm loadCashSol(PerformanceForm performanceForm, String username);

	public PerformanceForm updateCashBal(Map<String, BigDecimal> jsonMap, String username);

	public PerformanceForm updateOtherAsset(Map<String, BigDecimal> jsonMap, String username);

}
