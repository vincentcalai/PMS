package com.pms.pmsapp.manageportfolio.dividend.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.dividend.web.DividendForm;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class DividendController {

	private static final Logger log = LoggerFactory.getLogger(DividendController.class);

	@Autowired
	private DividendService dividendService;

	@RequestMapping(value = "/dividend/init", method = RequestMethod.POST)
	public DividendForm init(@RequestBody DividendForm dividendForm) {
		log.info("dividend init in Controller");
		return dividendService.initPage(dividendForm);
	}

	@RequestMapping(value = "/dividend/retrieveStockInfo", method = RequestMethod.POST)
	public DividendForm retrieveStockInfo(@RequestBody DividendForm dividendForm) {
		log.info("retrieveStockInfo Div in Controller");

		return dividendService.retrieveStockInfo(dividendForm);
	}

	@RequestMapping(value = "/dividend/add", method = RequestMethod.POST)
	public DividendForm addDividend(@RequestBody DividendForm dividendForm, Authentication authentication)
			throws IOException {
		log.info("addDivided in Controller.. ");

		String username = authentication.getName();

		return dividendService.addDividend(dividendForm, username);

	}

	@RequestMapping(value = "/dividend/retrievePortDiv", method = RequestMethod.POST)
	public DividendForm retrievePortDiv(@RequestBody DividendForm dividendForm) {
		log.info("retrievePortDiv in Controller");

		return dividendService.retrievePortDiv(dividendForm);
	}
}
