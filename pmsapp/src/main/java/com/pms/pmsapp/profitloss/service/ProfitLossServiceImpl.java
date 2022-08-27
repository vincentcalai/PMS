package com.pms.pmsapp.profitloss.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioService;
import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;
import com.pms.pmsapp.profitloss.repository.dao.ProfitLossDao;
import com.pms.pmsapp.profitloss.web.ProfitLossForm;
import com.pms.pmsapp.util.constant.ConstantUtil;

import yahoofinance.quotes.stock.StockQuote;

@Service
public class ProfitLossServiceImpl implements ProfitLossService {

	private static final Logger log = LoggerFactory.getLogger(ProfitLossServiceImpl.class);

	@Autowired
	private ProfitLossDao profitLossDao;

	@Autowired
	private PortfolioService portfolioService;

	@Override
	public List<String> getAllCurr() {
		return profitLossDao.getAllCurr();
	}

	@Override
	public List<UnrealPL> getUnrealisedList(long portId) {
		return profitLossDao.getUnrealisedList(portId);
	}

	@Override
	public void computeUnrealisedList(String portfolio, String currency) {
		profitLossDao.computeUnrealisedList(portfolio, currency);
	}

	@Override
	public List<RealPL> getRealisedList(String portfolio, String currency) {
		return profitLossDao.getRealisedList(portfolio, currency);
	}

	@Override
	public void computeRealisedList(String portfolio, String currency) {
		profitLossDao.computeRealisedList(portfolio, currency);

	}

	@Override
	public UnrealTotalPL getUnrealisedTotalList(String portfolio) {
		return profitLossDao.getUnrealisedTotalList(portfolio);
	}

	@Override
	public RealTotalPL getRealisedTotalList(String portfolio) {
		return profitLossDao.getRealisedTotalList(portfolio);
	}

	@Override
	public StockWrapper findStock(String stockSym) {
		return profitLossDao.findStock(stockSym);
	}

	@Override
	public void updateLastVal(UnrealPL unrealPl) {
		profitLossDao.updateLastVal(unrealPl);
	}

	@Override
	public ProfitLossForm initPage(ProfitLossForm profitLossForm) {
		// TODO Auto-generated method stub
		List<String> portfolioNames = portfolioService.findAllPortfolioNames();
		List<String> currencys = getAllCurr();
		profitLossForm.setPortfolioList(portfolioNames);
		profitLossForm.setCurrList(currencys);
		return profitLossForm;
	}

	@Override
	public ProfitLossForm retrieveProfitLoss(ProfitLossForm profitLossForm) {

		profitLossForm.setRealisedList(null);
		profitLossForm.setUnrealisedList(null);
		profitLossForm.setErrMsg(null);

		String portfolio = profitLossForm.getSelectedPortfolio();
		String pnlType = profitLossForm.getSelectedPnlType();
		String currency = profitLossForm.getSelectedCurr();

		long portId = portfolioService.getPortIdFromPortName(portfolio);

		if (!(portfolio == "")) {
			if (pnlType.equals(ConstantUtil.PNL_TYPE_ALL) || pnlType.equals(ConstantUtil.PNL_TYPE_UNREAL)) {
				computeUnrealisedList(portfolio, currency);
				List<UnrealPL> unrealPlList = getUnrealisedList(portId);
				UnrealTotalPL unrealTotalPlList = getUnrealisedTotalList(portfolio);
				profitLossForm.setUnrealisedList(unrealPlList);
				profitLossForm.setUnrealisedTotalList(unrealTotalPlList);
			}
			if (pnlType.equals(ConstantUtil.PNL_TYPE_ALL) || pnlType.equals(ConstantUtil.PNL_TYPE_REAL)) {
				computeRealisedList(portfolio, currency);
				List<RealPL> realPlList = getRealisedList(portfolio, currency);
				RealTotalPL realTotalPlList = getRealisedTotalList(portfolio);
				profitLossForm.setRealisedList(realPlList);
				profitLossForm.setRealisedTotalList(realTotalPlList);
			}
		} else {
			profitLossForm.setErrMsg("Please select a portfolio.");
		}

		return profitLossForm;
	}

	@Override
	public void updateLivePrices(ProfitLossForm profitLossForm) {
		String portfolio = profitLossForm.getSelectedPortfolio();
		long portId = portfolioService.getPortIdFromPortName(portfolio);

		if (!(portfolio == "")) {
			List<UnrealPL> unrealPlList = getUnrealisedList(portId);

			log.info("get all unrealPl stocks positions..");

			for (UnrealPL unrealPl : unrealPlList) {
				String stockSym = unrealPl.getStockSymbol();
				StockWrapper stockWrapper = findStock(stockSym);
				try {
					StockQuote stockQuote = stockWrapper.getStock().getQuote(true);
					unrealPl.setLastTransPrice(stockQuote.getPrice());
					log.info("Stock Symbol: " + stockSym + " Last Price: " + unrealPl.getLastTransPrice());
					updateLastVal(unrealPl);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		}

	}
}
