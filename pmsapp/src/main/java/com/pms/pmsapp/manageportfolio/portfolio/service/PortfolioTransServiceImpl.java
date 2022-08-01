package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.portfolio.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioTransRepository;
import com.pms.pmsapp.manageportfolio.portfolio.repository.dao.PortfolioTransDao;
import com.pms.pmsapp.util.constant.ConstantUtil;

@Service
public class PortfolioTransServiceImpl implements PortfolioTransService {

	private static final Logger log = LoggerFactory.getLogger(PortfolioTransServiceImpl.class);

	@Autowired
	private PortfolioTransDao portfolioTransDao;

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@Autowired
	private DividendService dividendService;

	@Autowired
	private PortfolioTransRepository portfolioTransRepository;

	public List<PortfolioTrans> findAll(long portId, Pageable pageable) {
		log.info("findAll Trans in ServiceImpl");
		return portfolioTransDao.findAll(portId, pageable);
	}

	public List<MktExchg> findAllMktExchg() {
		log.info("findAllMktExchg Trans in ServiceImpl");
		return portfolioTransDao.findAllMktExchg();
	}

	public void addPortfolioTrans(PortfolioTrans portfolioTrans) {
		portfolioTransDao.addPortfolioTrans(portfolioTrans);
	}

	public void deletePortfolioTrans(long id) {
		// portfolioTransDao.deletePortfolioTrans(id);
		portfolioTransRepository.deleteById(id);
	}

	public void populateToHolding(long id, long portId) {
		portfolioTransDao.populateToHolding(id, portId);
	}

	public long getNextTransID() {
		return portfolioTransDao.getNextTransID();
	}

	public int validateSellAction(PortfolioTrans portfolioTrans) {
		return portfolioTransDao.validateSellAction(portfolioTrans);
	}

	@Override
	public String findSuffix(String stockExchg) {
		return portfolioTransDao.findSuffix(stockExchg);
	}

	@Override
	public int findCurrentStockHold(PortfolioTrans portfolioTrans) {
		return portfolioTransDao.findCurrentStockHold(portfolioTrans);
	}

	@Override
	public long findAllCount(long portId) {
		return portfolioTransDao.findAllCount(portId);
	}

	@Override
	public List<PortfolioTrans> searchTrans(long portId, String searchText, Pageable pageable) {
		return portfolioTransDao.searchTrans(portId, searchText, pageable);
	}

	@Override
	public long searchTransCount(long portId, String searchText) {
		return portfolioTransDao.searchTransCount(portId, searchText);
	}

	@Override
	public PortfolioTrans retrieveStockInfo(PortfolioTrans portfolioTrans) {
		String stockSym = portfolioTrans.getStockSymbol();
		StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
		try {
			String stockExchg = stockWrapper.getStock().getStockExchange();
			String stockName = stockWrapper.getStock().getName();
			BigDecimal transPrice = stockWrapper.getStock().getQuote(true).getPrice();
			portfolioTrans.setStockExchg(ConstantUtil.exchgSuffmap.get(stockExchg));
			log.info("Stock: " + stockName + " Trans Price: " + transPrice);
			portfolioTrans.setStockName(stockName);
			portfolioTrans.setTransPrice(transPrice);
		} catch (Exception e) {
			portfolioTrans.setErrMsg("Stock symbol not found. Fail to get stock info.");
			log.error(e.getMessage());
		}

		return portfolioTrans;
	}

	@Override
	public PortfolioTrans addPortfolioTrans(PortfolioTrans portfolioTrans, long portId, String username) {
		long id = 0;
		int sellActionCheck = 0;

		if (username != null) {
			portfolioTrans.setCreatedBy(username);
		}

		String action = portfolioTrans.getAction();
		int noOfShare = portfolioTrans.getNoOfShare();
		String stockSym = portfolioTrans.getStockSymbol();
		String stockExchg = portfolioTrans.getStockExchg();
		String transPrice = portfolioTrans.getTransPrice().toString();
		Date backDatedDate = portfolioTrans.getBackDatedDate() == null ? new Date() : portfolioTrans.getBackDatedDate();
		portfolioTrans.setPortId(portId);
		portfolioTrans.setStockSymbol(stockSym);
		portfolioTrans.setBackDatedDate(backDatedDate);

		if (noOfShare <= 0) {
			portfolioTrans
					.setErrMsg("Invalid No. Of Share. No. Of Share should be more than 0. Save transaction failed.");
			return portfolioTrans;
		}

		StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
		if ((stockWrapper.getStock() == null || stockWrapper.getStock().getQuote().getPrice() == null)) {
			portfolioTrans.setErrMsg("Stock Symbol is invalid, unable to get stock price. Save transaction failed.");
			return portfolioTrans;
		}

		if (portfolioTrans.getAction().equals(ConstantUtil.SELL_ACTION)) {
			sellActionCheck = validateSellAction(portfolioTrans);
		}

		if (sellActionCheck >= 0) {
			id = getNextTransID();
			portfolioTrans.setId(id);

			addPortfolioTrans(portfolioTrans);

			populateToHolding(id, portId);

			if (portfolioTrans.getAction().equals(ConstantUtil.SELL_ACTION)) {
				dividendService.updateDivRec(portId, stockSym, noOfShare);
			}

			try {
				BigDecimal lastTransPrice = stockWrapper.getStock().getQuote(true).getPrice();
				log.info("Stock: " + stockSym + " Last Transacted Price: " + lastTransPrice);
				portfolioHoldService.computeHoldingsJob(stockSym, lastTransPrice);
			} catch (Exception e) {
				portfolioTrans.setErrMsg(
						"An unexpected error occurred while updating real time price. Update of real time price failed.");
				log.error(e.getMessage());
			}

			portfolioTrans.setSystemMsg("Transaction created successfully. Transaction " + action + " " + stockExchg
					+ ":" + stockSym + " " + noOfShare + " AT " + transPrice);

		} else {
			portfolioTrans.setErrMsg("You do not have sufficient shares in your holdings to register this trade.");
		}

		return portfolioTrans;
	}

}
