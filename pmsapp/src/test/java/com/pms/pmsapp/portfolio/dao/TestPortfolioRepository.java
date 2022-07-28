package com.pms.pmsapp.portfolio.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioRepository;
import com.pms.pmsapp.manageportfolio.portfolio.repository.dao.PortfolioDaoImpl;

@DataJpaTest
@ContextConfiguration(classes = { PortfolioDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
class TestPortfolioRepository {

	@Autowired
	private PortfolioRepository portfolioRepository;

	Portfolio portfolioObj1 = null;

	@BeforeAll
	private void setup() {
		portfolioObj1 = new Portfolio();

		portfolioObj1.setPortfolioName("Test Portfolio 1");
		portfolioObj1.setCreatedBy("user1");
		portfolioObj1.setCreatedDate(new Date());
		portfolioObj1.setLastMdfyBy("user1");
		portfolioObj1.setLastMdfyDt(new Date());
		portfolioObj1.setRemarks("This is a test remark");
	}

	@Test
	void testSavePortfolio() {

		portfolioRepository.save(portfolioObj1);

		Optional<Portfolio> result = portfolioRepository.findById(1L);

		assertEquals("Test Portfolio 1", result.get().getPortfolioName());
		assertEquals("user1", result.get().getCreatedBy());
		assertEquals("user1", result.get().getLastMdfyBy());
	}

}
