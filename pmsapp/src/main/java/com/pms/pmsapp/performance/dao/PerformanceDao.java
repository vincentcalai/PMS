package com.pms.pmsapp.performance.dao;

import java.math.BigDecimal;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;

public interface PerformanceDao {
	public ETFPerformance findEtfPerformance(String portfolio);

	public StockPerformance findStockPerformance(String portfolio);

	public GphyPerformance findGphyPerformance(String selectedPortfolio);

	public BigDecimal findUserBankBal(String username);

	public BigDecimal findUserOtherAsset(String username);

	public BigDecimal findUserTotalInvestment(String username);

	public String updateCashBal(BigDecimal newCashBal, String username);

	public String updateOtherAsset(BigDecimal newOtherAsset, String username);

}
