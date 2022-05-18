package com.pms.pmsapp.profitloss.controller;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioService;
import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;
import com.pms.pmsapp.profitloss.service.ProfitLossService;
import com.pms.pmsapp.profitloss.web.ProfitLossForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahoofinance.quotes.stock.StockQuote;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class ProfitLossController {

	private static final Logger log = LoggerFactory.getLogger(ProfitLossController.class);

	private final String PNL_TYPE_ALL = "ALL";
	private final String PNL_TYPE_UNREAL = "UNREALISED";
	private final String PNL_TYPE_REAL = "REALISED";

	@Autowired
	private ProfitLossService profitLossService;

  @Autowired
  PortfolioService portfolioService;


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

    long portId = portfolioService.getPortIdFromPortName(portfolio);

		if(!(portfolio == "")) {
			if(pnlType.equals(PNL_TYPE_ALL) || pnlType.equals(PNL_TYPE_UNREAL)) {
				profitLossService.computeUnrealisedList(portfolio, currency);
				List<UnrealPL> unrealPlList = profitLossService.getUnrealisedList(portId);
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

	@RequestMapping(value="/profitloss/updateliveprices", method=RequestMethod.POST)
	public void updateLivePrices(@RequestBody ProfitLossForm profitLossForm) {
		log.info("updateLivePrices in Controller");

		String portfolio = profitLossForm.getSelectedPortfolio();
    long portId = portfolioService.getPortIdFromPortName(portfolio);

		if(!(portfolio == "")) {
				List<UnrealPL> unrealPlList = profitLossService.getUnrealisedList(portId);

				log.info("get all unrealPl stocks positions..");

				for(UnrealPL unrealPl : unrealPlList) {
					String stockSym = unrealPl.getStockSymbol();
					StockWrapper stockWrapper = profitLossService.findStock(stockSym);
					try {
						StockQuote stockQuote = stockWrapper.getStock().getQuote(true);
						unrealPl.setLastTransPrice(stockQuote.getPrice());
						log.info("Stock Symbol: " + stockSym + " Last Price: " + unrealPl.getLastTransPrice());
						profitLossService.updateLastVal(unrealPl);
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}


		}
	}

}
