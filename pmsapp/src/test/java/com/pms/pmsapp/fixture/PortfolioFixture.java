package com.pms.pmsapp.fixture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;

public class PortfolioFixture {

	public static List<Portfolio> createPortfolioFixture() {

		Portfolio portfolioObj1 = new Portfolio();

		portfolioObj1.setPortfolioName("Test Portfolio 1");
		portfolioObj1.setCreatedBy("user1");
		portfolioObj1.setCreatedDate(new Date());
		portfolioObj1.setLastMdfyBy("user1");
		portfolioObj1.setLastMdfyDt(new Date());
		portfolioObj1.setRemarks("This is a test remark 1");

		Portfolio portfolioObj2 = new Portfolio();

		portfolioObj2.setPortfolioName("Test Portfolio 2");
		portfolioObj2.setCreatedBy("user1");
		portfolioObj2.setCreatedDate(new Date());
		portfolioObj2.setLastMdfyBy("user1");
		portfolioObj2.setLastMdfyDt(new Date());
		portfolioObj2.setRemarks("This is a test remark 2");

		List<Portfolio> list = new ArrayList<>();
		list.add(portfolioObj1);
		list.add(portfolioObj2);

		return list;
	}

}
