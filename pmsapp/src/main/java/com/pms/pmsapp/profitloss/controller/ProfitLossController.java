package com.pms.pmsapp.profitloss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.profitloss.service.ProfitLossService;
import com.pms.pmsapp.profitloss.web.ProfitLossForm;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class ProfitLossController {

	private static final Logger log = LoggerFactory.getLogger(ProfitLossController.class);

	@Autowired
	private ProfitLossService profitLossService;

	@RequestMapping(value = "/profitloss/init", method = RequestMethod.POST)
	public ProfitLossForm init(@RequestBody ProfitLossForm profitLossForm) {
		log.info("profitloss init in Controller");
		return profitLossService.initPage(profitLossForm);
	}

	@RequestMapping(value = "/profitloss/retrieve", method = RequestMethod.POST)
	public ProfitLossForm retrieve(@RequestBody ProfitLossForm profitLossForm) {
		log.info("profitloss retrieve in Controller");

		return profitLossService.retrieveProfitLoss(profitLossForm);
	}

	@RequestMapping(value = "/profitloss/updateliveprices", method = RequestMethod.POST)
	public void updateLivePrices(@RequestBody ProfitLossForm profitLossForm) {
		log.info("updateLivePrices in Controller");

		profitLossService.updateLivePrices(profitLossForm);
	}

}
