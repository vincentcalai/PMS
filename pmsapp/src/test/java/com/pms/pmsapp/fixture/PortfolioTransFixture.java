package com.pms.pmsapp.fixture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;

public class PortfolioTransFixture {

	public static List<PortfolioTrans> createPortfolioTransFixture() {

		PortfolioTrans portfolioTransObj1 = new PortfolioTrans();

		portfolioTransObj1.setId(1L);
		portfolioTransObj1.setPortId(1L);
		portfolioTransObj1.setStockName("Microsoft Corp.");
		portfolioTransObj1.setStockSymbol("MSFT");
		portfolioTransObj1.setStockExchg("NASDAQ");
		portfolioTransObj1.setNoOfShare(100);
		portfolioTransObj1.setTransPrice(new BigDecimal("250.66"));
		portfolioTransObj1.setTotalAmt(new BigDecimal("25066"));
		portfolioTransObj1.setAction("B");
		portfolioTransObj1.setBackDatedDate(null);
		portfolioTransObj1.setCreatedBy("user1");
		portfolioTransObj1.setCreatedDt(new Date());
		portfolioTransObj1.setRemarks("This is a test remark 1");
		portfolioTransObj1.setCurrentStockHold(50);

		PortfolioTrans portfolioTransObj2 = new PortfolioTrans();

		portfolioTransObj2.setId(2L);
		portfolioTransObj2.setPortId(2L);
		portfolioTransObj2.setStockName("Amazon Inc.");
		portfolioTransObj2.setStockSymbol("AMZN");
		portfolioTransObj2.setStockExchg("NASDAQ");
		portfolioTransObj2.setNoOfShare(100);
		portfolioTransObj2.setTransPrice(new BigDecimal("113.98"));
		portfolioTransObj2.setTotalAmt(new BigDecimal("11398"));
		portfolioTransObj2.setAction("B");
		portfolioTransObj2.setBackDatedDate(null);
		portfolioTransObj2.setCreatedBy("user1");
		portfolioTransObj2.setCreatedDt(new Date());
		portfolioTransObj2.setRemarks("This is a test remark 2");
		portfolioTransObj2.setCurrentStockHold(30);

		List<PortfolioTrans> list = new ArrayList<>();
		list.add(portfolioTransObj1);
		list.add(portfolioTransObj2);

		return list;
	}

}
