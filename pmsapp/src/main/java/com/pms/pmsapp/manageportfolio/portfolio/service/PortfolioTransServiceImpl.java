package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.data.MktExchg;
import com.pms.pmsapp.common.repository.MktExchgRepository;
import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioTransRepository;
import com.pms.pmsapp.manageportfolio.portfolio.repository.dao.PortfolioTransDao;
import com.pms.pmsapp.manageportfolio.portfolio.web.PortfolioTransForm;
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

	@Autowired
	private MktExchgRepository mktExchgRepository;

	public List<PortfolioTrans> findAll(long portId, Pageable pageable) {
		log.info("findAll Trans in ServiceImpl");
		return portfolioTransRepository.findAllByPortId(portId, pageable);
	}

	public List<MktExchg> findAllMktExchg() {
		return mktExchgRepository.findAll();
	}

	public void addPortfolioTrans(PortfolioTrans portfolioTrans) {
		BigDecimal transactionPrice = portfolioTrans.getTransPrice();
		transactionPrice.setScale(2, RoundingMode.HALF_UP);
		portfolioTrans.setTransPrice(transactionPrice);

		BigDecimal totalAmt = transactionPrice.multiply(new BigDecimal(portfolioTrans.getNoOfShare()));
		portfolioTrans.setTotalAmt(totalAmt);
		portfolioTransRepository.save(portfolioTrans);
	}

	public void deletePortfolioTrans(long id) {
		portfolioTransRepository.deleteById(id);
	}

	public void populateToHolding(long id, long portId) {
		portfolioTransDao.populateToHolding(id, portId);
	}

	public int validateSellAction(PortfolioTrans portfolioTrans) {
		return portfolioTransDao.validateSellAction(portfolioTrans);
	}

	@Override
	public String findSuffix(String stockExchg) {
		MktExchg mktExchg = mktExchgRepository.findByMktExchgName(stockExchg);
		return mktExchg.getSuffix();
	}

	@Override
	public int findCurrentStockHold(PortfolioTrans portfolioTrans) {
		return portfolioTransDao.findCurrentStockHold(portfolioTrans);
	}

	@Override
	public long findAllCount(long portId) {
		return portfolioTransRepository.countByPortId(portId);
	}

	@Override
	public List<PortfolioTrans> searchTrans(long portId, String searchText, Pageable pageable) {
		return portfolioTransDao.searchTrans(portId, searchText, pageable);
	}

	@Override
	public long searchTransCount(long portId, String searchText) {
		return portfolioTransRepository.searchTransCount(portId, searchText);
	}

	@Override
	public PortfolioTransForm retrieveStockInfo(PortfolioTransForm portfolioTrans) {

		PortfolioTransForm portfolioTransForm = new PortfolioTransForm();

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
			portfolioTransForm.setErrMsg("Stock symbol not found. Fail to get stock info.");
			log.error(e.getMessage());
		}

		// add portfolioTrans json to portfolioTransForm here

		return portfolioTransForm;
	}

	@Override
	public PortfolioTransForm addPortfolioTrans(PortfolioTransForm portfolioTransForm, long portId, String username) {

		long id = 0;
		int sellActionCheck = 0;

		if (username != null) {
			portfolioTransForm.setCreatedBy(username);
		}

		String action = portfolioTransForm.getAction();
		int noOfShare = portfolioTransForm.getNoOfShare();
		String stockSym = portfolioTransForm.getStockSymbol();
		String stockExchg = portfolioTransForm.getStockExchg();
		String transPrice = portfolioTransForm.getTransPrice().toString();
		Date backDatedDate = portfolioTransForm.getBackDatedDate() == null ? new Date()
				: portfolioTransForm.getBackDatedDate();
		portfolioTransForm.setPortId(portId);
		portfolioTransForm.setBackDatedDate(backDatedDate);

		if (noOfShare <= 0) {
			portfolioTransForm
					.setErrMsg("Invalid No. Of Share. No. Of Share should be more than 0. Save transaction failed.");
			return portfolioTransForm;
		}

		StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
		if ((stockWrapper.getStock() == null || stockWrapper.getStock().getQuote().getPrice() == null)) {
			portfolioTransForm
					.setErrMsg("Stock Symbol is invalid, unable to get stock price. Save transaction failed.");
			return portfolioTransForm;
		}

		PortfolioTrans portfolioTrans = new PortfolioTrans();
		portfolioTrans.setAction(portfolioTransForm.getAction());
		portfolioTrans.setCreatedBy(portfolioTransForm.getCreatedBy());
		portfolioTrans.setCreatedDt(portfolioTransForm.getCreatedDt());
		portfolioTrans.setId(portfolioTransForm.getId());
		portfolioTrans.setNoOfShare(portfolioTransForm.getNoOfShare());
		portfolioTrans.setPortId(portfolioTransForm.getPortId());
		portfolioTrans.setRemarks(portfolioTransForm.getRemarks());
		portfolioTrans.setStockExchg(portfolioTransForm.getStockExchg());
		portfolioTrans.setStockName(portfolioTransForm.getStockName());
		portfolioTrans.setStockSymbol(portfolioTransForm.getStockSymbol());
		portfolioTrans.setTotalAmt(portfolioTransForm.getTotalAmt());
		portfolioTrans.setTransPrice(portfolioTransForm.getTransPrice());

		if (portfolioTransForm.getAction().equals(ConstantUtil.SELL_ACTION)) {
			sellActionCheck = validateSellAction(portfolioTrans);
		}

		if (sellActionCheck >= 0) {
			id = portfolioTransRepository.getNextTransID();
			portfolioTransForm.setId(id);

			addPortfolioTrans(portfolioTrans);

			populateToHolding(id, portId);

			if (portfolioTransForm.getAction().equals(ConstantUtil.SELL_ACTION)) {
				dividendService.updateDivRec(portId, stockSym, noOfShare);
			}

			try {
				BigDecimal lastTransPrice = stockWrapper.getStock().getQuote(true).getPrice();
				log.info("Stock: " + stockSym + " Last Transacted Price: " + lastTransPrice);
				portfolioHoldService.computeHoldingsJob(stockSym, lastTransPrice);
				portfolioTransForm.setSystemMsg("Transaction created successfully. Transaction " + action + " "
						+ stockExchg + ":" + stockSym + " " + noOfShare + " AT " + transPrice);
			} catch (Exception e) {
				portfolioTransForm.setErrMsg(
						"An unexpected error occurred while updating real time price. Update of real time price failed.");
				log.error(e.getMessage());
			}

		} else {
			portfolioTransForm.setErrMsg("You do not have sufficient shares in your holdings to register this trade.");
		}

		// add portfolioTrans json to portfolioTransForm here

		return portfolioTransForm;
	}

}
