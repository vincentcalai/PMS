package com.pms.pmsapp.performance.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioService;
import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.PortfolioPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import com.pms.pmsapp.performance.service.PerformanceService;
import com.pms.pmsapp.performance.web.PerformanceForm;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;
import com.pms.pmsapp.profitloss.service.ProfitLossService;

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

	private static final String mapKey = "key";

	@RequestMapping(value = "/performance/init", method = RequestMethod.POST)
	public PerformanceForm init(@RequestBody PerformanceForm performanceForm) {
		log.info("performance init in Controller");
		List<String> portfolios = profitLossService.getPortfolios();
		performanceForm.setPortfolioList(portfolios);
		return performanceForm;
	}

	@RequestMapping(value = "/performance/loadPerfTab", method = RequestMethod.POST)
	public PerformanceForm loadPerfTab(@RequestBody PerformanceForm performanceForm) {
		log.info("performance loadPerfTab in Controller");

		String selectedPortfolio = performanceForm.getSelectedPortfolio();
		long portId = portfolioService.getPortIdFromPortName(selectedPortfolio);

		log.info("backend init investment data");
		// init investment data
		profitLossService.computeUnrealisedList(selectedPortfolio, convCurrency);
		UnrealTotalPL unrealTotalPlList = profitLossService.getUnrealisedTotalList(selectedPortfolio);
		GphyPerformance grpyPerformance = performanceService.findGphyPerformance(selectedPortfolio);

		if (unrealTotalPlList != null) {
			portfolioPerformance = new PortfolioPerformance(unrealTotalPlList.getTotalAmt(),
					unrealTotalPlList.getMktValue(), unrealTotalPlList.getConvProfitLoss(),
					unrealTotalPlList.getProfitLossPct());
			etfPerformance = performanceService.findEtfPerformance(selectedPortfolio);
			stockPerformance = performanceService.findStockPerformance(selectedPortfolio);
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

	@RequestMapping(value = "/performance/loadCashSol", method = RequestMethod.POST)
	public PerformanceForm loadCashSol(@RequestBody PerformanceForm performanceForm, Authentication authentication) {
		log.info("performance loadCashSol in Controller");

		String username = authentication.getName();

		log.info("backend init cash solution data");
		// init cash solution data
		BigDecimal bankBal = performanceService.findUserBankBal(username);
		BigDecimal totalInvestment = performanceService.findUserTotalInvestment(username);
		BigDecimal bankAndInvest = bankBal.add(totalInvestment);
		performanceForm.setBankBal(bankBal);
		performanceForm.setBankAndInvest(bankAndInvest);
		return performanceForm;
	}

	@RequestMapping(value = "/performance/updateCashBal", method = RequestMethod.POST)
	public PerformanceForm updateCashBal(@RequestBody Map<String, Integer> jsonMap, Authentication authentication) {
		log.info("performance updateCashBal in Controller");

		String username = authentication.getName();

		String msg;

		PerformanceForm performanceForm = new PerformanceForm();

		try {
			msg = performanceService.updateCashBal(jsonMap.get(mapKey), username);
			performanceForm.setMsg(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = "Update failed. Cash Balance was reverted to the previous amount.";
			performanceForm.setErrorMsg(msg);
			e.printStackTrace();
		}

		return performanceForm;
	}

}
