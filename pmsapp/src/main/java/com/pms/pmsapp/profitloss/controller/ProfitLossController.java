package com.pms.pmsapp.profitloss.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;
import com.pms.pmsapp.profitloss.service.ProfitLossService;
import com.pms.pmsapp.profitloss.web.ProfitLossForm;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class ProfitLossController {
	
	private static final Logger log = LoggerFactory.getLogger(ProfitLossController.class);
	
	private final String PNL_TYPE_ALL = "ALL";
	private final String PNL_TYPE_UNREAL = "UNREALISED";
	private final String PNL_TYPE_REAL = "REALISED";
	
	@Autowired
	private ProfitLossService profitLossService;
	
	
	@RequestMapping(value="/profitloss/init", method=RequestMethod.POST)
	public ProfitLossForm init(@RequestBody ProfitLossForm profitLossForm) {
		log.info("profitloss init in Controller");
		List<String> portfolios = profitLossService.getPortfolios();
		List<String> currencys = profitLossService.getAllCurr();
		profitLossForm.setPortfolioList(portfolios);
		profitLossForm.setCurrList(currencys);
		return profitLossForm;
	}

	@RequestMapping(value="/profitloss/retrieve", method=RequestMethod.POST)
	public ProfitLossForm retrieve(@RequestBody ProfitLossForm profitLossForm) {
		log.info("profitloss retrieve in Controller");
		profitLossForm.setRealisedList(null);
		profitLossForm.setUnrealisedList(null);
		profitLossForm.setErrMsg(null);
		
		String portfolio = profitLossForm.getSelectedPortfolio();
		String pnlType = profitLossForm.getSelectedPnlType();
		String currency = profitLossForm.getSelectedCurr();
		
		if(!(portfolio == "")) {
			if(pnlType.equals(PNL_TYPE_ALL) || pnlType.equals(PNL_TYPE_UNREAL)) {
				profitLossService.computeUnrealisedList(portfolio, currency);
				List<UnrealPL> unrealPlList = profitLossService.getUnrealisedList();
				UnrealTotalPL unrealTotalPlList = profitLossService.getUnrealisedTotalList(portfolio);
				profitLossForm.setUnrealisedList(unrealPlList);
				profitLossForm.setUnrealisedTotalList(unrealTotalPlList);
			} 
			if(pnlType.equals(PNL_TYPE_ALL) || pnlType.equals(PNL_TYPE_REAL)) {
				profitLossService.computeRealisedList(portfolio, currency);
				List<RealPL> realPlList = profitLossService.getRealisedList(portfolio, currency);
				RealTotalPL realTotalPlList = profitLossService.getRealisedTotalList(portfolio);
				profitLossForm.setRealisedList(realPlList);
				profitLossForm.setRealisedTotalList(realTotalPlList);
			} 
		} else {
			profitLossForm.setErrMsg("Please select a portfolio.");
		}
		
		return profitLossForm;
	}
	
}
