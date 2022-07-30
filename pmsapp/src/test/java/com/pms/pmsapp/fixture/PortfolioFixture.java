package com.pms.pmsapp.fixture;

import java.util.Date;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;

public class PortfolioFixture {

	public static Portfolio createPortfolioFixture() {

		Portfolio portfolioObj1 = new Portfolio();

		portfolioObj1.setPortfolioName("Test Portfolio 1");
		portfolioObj1.setCreatedBy("user1");
		portfolioObj1.setCreatedDate(new Date());
		portfolioObj1.setLastMdfyBy("user1");
		portfolioObj1.setLastMdfyDt(new Date());
		portfolioObj1.setRemarks("This is a test remark");

		return portfolioObj1;
	}

}
