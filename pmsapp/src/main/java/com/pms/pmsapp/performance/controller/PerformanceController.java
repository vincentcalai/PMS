package com.pms.pmsapp.performance.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.performance.service.PerformanceService;
import com.pms.pmsapp.performance.web.PerformanceForm;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PerformanceController {

	@Autowired
	private PerformanceService performanceService;

	private static final Logger log = LoggerFactory.getLogger(PerformanceController.class);

	@RequestMapping(value = "/performance/init", method = RequestMethod.POST)
	public PerformanceForm init(@RequestBody PerformanceForm performanceForm) {
		log.info("performance init in Controller");

		return performanceService.initPage(performanceForm);
	}

	@RequestMapping(value = "/performance/loadInvest", method = RequestMethod.POST)
	public PerformanceForm loadInvest(@RequestBody PerformanceForm performanceForm) {
		log.info("performance loadPerfTab in Controller");

		return performanceService.loadInvest(performanceForm);
	}

	@RequestMapping(value = "/performance/loadCashSol", method = RequestMethod.POST)
	public PerformanceForm loadCashSol(@RequestBody PerformanceForm performanceForm, Authentication authentication) {
		log.info("performance loadCashSol in Controller");

		String username = authentication.getName();

		log.info("backend init cash solution data");

		return performanceService.loadCashSol(performanceForm, username);
	}

	@RequestMapping(value = "/performance/updateCashBal", method = RequestMethod.POST)
	public PerformanceForm updateCashBal(@RequestBody Map<String, BigDecimal> jsonMap, Authentication authentication) {
		log.info("performance updateCashBal in Controller");

		String username = authentication.getName();

		return performanceService.updateCashBal(jsonMap, username);
	}

	@RequestMapping(value = "/performance/updateOtherAsset", method = RequestMethod.POST)
	public PerformanceForm updateOtherAsset(@RequestBody Map<String, BigDecimal> jsonMap,
			Authentication authentication) {
		log.info("performance updateCashBal in Controller");

		String username = authentication.getName();

		return performanceService.updateOtherAsset(jsonMap, username);
	}

}
