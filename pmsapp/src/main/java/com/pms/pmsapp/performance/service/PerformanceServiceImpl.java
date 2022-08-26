package com.pms.pmsapp.performance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioService;
import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.PortfolioPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import com.pms.pmsapp.performance.repository.dao.PerformanceDao;
import com.pms.pmsapp.performance.web.PerformanceForm;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;
import com.pms.pmsapp.profitloss.service.ProfitLossService;
import com.pms.pmsapp.util.constant.ConstantUtil;

@Service
public class PerformanceServiceImpl implements PerformanceService {

	PortfolioPerformance portfolioPerformance;
	ETFPerformance etfPerformance;
	StockPerformance stockPerformance;

	private static final String mapKey = "key";

	@Autowired
	private PerformanceDao performanceDao;

	@Autowired
	private PerformanceService performanceService;

	@Autowired
	private ProfitLossService profitLossService;

	@Autowired
	private PortfolioService portfolioService;

	@Override
	public ETFPerformance findEtfPerformance(String portfolio) {
		return performanceDao.findEtfPerformance(portfolio);
	}

	@Override
	public StockPerformance findStockPerformance(String portfolio) {
		return performanceDao.findStockPerformance(portfolio);
	}

	@Override
	public GphyPerformance findGphyPerformance(String selectedPortfolio) {
		return performanceDao.findGphyPerformance(selectedPortfolio);
	}

	@Override
	public BigDecimal findUserBankBal(String username) {
		return performanceDao.findUserBankBal(username);
	}

	@Override
	public BigDecimal findUserOtherAsset(String username) {
		return performanceDao.findUserOtherAsset(username);
	}

	@Override
	public BigDecimal findUserTotalInvestment(String username) {
		return performanceDao.findUserTotalInvestment(username);
	}

	@Override
	public String updateCashBal(BigDecimal newCashBal, String username) {
		return performanceDao.updateCashBal(newCashBal, username);
	}

	@Override
	public String updateOtherAsset(BigDecimal newOtherAsset, String username) {
		return performanceDao.updateOtherAsset(newOtherAsset, username);
	}

	@Override
	public PerformanceForm initPage(PerformanceForm performanceForm) {
		List<String> portfolios = profitLossService.getPortfolios();
		performanceForm.setPortfolioList(portfolios);
		return performanceForm;
	}

	@Override
	public PerformanceForm loadInvest(PerformanceForm performanceForm) {

		String selectedPortfolio = performanceForm.getSelectedPortfolio();
		// long portId = portfolioService.getPortIdFromPortName(selectedPortfolio);

		// init investment data
		profitLossService.computeUnrealisedList(selectedPortfolio, ConstantUtil.CURRENCY_SGD);
		UnrealTotalPL unrealTotalPlList = profitLossService.getUnrealisedTotalList(selectedPortfolio);
		GphyPerformance grpyPerformance = findGphyPerformance(selectedPortfolio);

		if (unrealTotalPlList != null) {
			portfolioPerformance = new PortfolioPerformance(unrealTotalPlList.getTotalAmt(),
					unrealTotalPlList.getMktValue(), unrealTotalPlList.getConvProfitLoss(),
					unrealTotalPlList.getProfitLossPct());
			etfPerformance = findEtfPerformance(selectedPortfolio);
			stockPerformance = findStockPerformance(selectedPortfolio);
		} else {
			portfolioPerformance = new PortfolioPerformance(new BigDecimal(0), new BigDecimal(0), new BigDecimal(0),
					new BigDecimal(0));
			etfPerformance = new ETFPerformance(ETFPerformance.etfName, new BigDecimal(0), new BigDecimal(0),
					new BigDecimal(0), new BigDecimal(0));
			stockPerformance = new StockPerformance(StockPerformance.stockName, new BigDecimal(0), new BigDecimal(0),
					new BigDecimal(0), new BigDecimal(0));
		}

		performanceForm.setPortfolioPerformance(portfolioPerformance);
		performanceForm.setEtfPerformance(etfPerformance);
		performanceForm.setStockPerformance(stockPerformance);
		performanceForm.setGphyPerformance(grpyPerformance);
		return performanceForm;
	}

	@Override
	public PerformanceForm loadCashSol(PerformanceForm performanceForm, String username) {
		// init cash solution data
		BigDecimal bankBal = performanceService.findUserBankBal(username);
		BigDecimal otherAsset = performanceService.findUserOtherAsset(username);
		BigDecimal totalInvestment = performanceService.findUserTotalInvestment(username);
		BigDecimal totalWealth = bankBal.add(totalInvestment).add(otherAsset);
		performanceForm.setBankBal(bankBal);
		performanceForm.setOtherAsset(otherAsset);
		performanceForm.setTotalWealth(totalWealth);

		return performanceForm;
	}

	@Override
	public PerformanceForm updateCashBal(Map<String, BigDecimal> jsonMap, String username) {
		String msg;

		PerformanceForm performanceForm = new PerformanceForm();

		try {
			msg = performanceService.updateCashBal(jsonMap.get(mapKey), username);
			performanceForm.setMsg(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = "Update failed. Cash Balance was not updated.";
			performanceForm.setErrorMsg(msg);
			e.printStackTrace();
		}

		return performanceForm;
	}

	@Override
	public PerformanceForm updateOtherAsset(Map<String, BigDecimal> jsonMap, String username) {

		String msg;

		PerformanceForm performanceForm = new PerformanceForm();

		try {
			msg = performanceService.updateOtherAsset(jsonMap.get(mapKey), username);
			performanceForm.setMsg(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = "Update failed. Other Asset amount was not updated.";
			performanceForm.setErrorMsg(msg);
			e.printStackTrace();
		}

		return performanceForm;
	}

}
