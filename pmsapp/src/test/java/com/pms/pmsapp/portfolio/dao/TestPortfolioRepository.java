package com.pms.pmsapp.portfolio.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.fixture.PortfolioFixture;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioRepository;
import com.pms.pmsapp.manageportfolio.portfolio.repository.dao.PortfolioDaoImpl;

@DataJpaTest
@ContextConfiguration(classes = { PortfolioDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
class TestPortfolioRepository {

	@Autowired
	private PortfolioRepository portfolioRepository;

	Portfolio portfolioSaveObj = null;
	Portfolio portfolioObj1 = null;

	@BeforeAll
	private void setup() {
		List<Portfolio> list = PortfolioFixture.createPortfolioFixture();
		portfolioRepository.saveAll(list);
	}

	@AfterAll
	private void tearDown() {
		portfolioRepository.deleteAll();
	}

	@Test
	void testSavePortfolio() {

		portfolioSaveObj = new Portfolio();

		portfolioSaveObj.setPortfolioName("Test Name");
		portfolioSaveObj.setCreatedBy("user8");
		portfolioSaveObj.setCreatedDate(new Date());
		portfolioSaveObj.setLastMdfyBy("user8");
		portfolioSaveObj.setLastMdfyDt(new Date());
		portfolioSaveObj.setRemarks("This is a test remark");

		portfolioRepository.save(portfolioSaveObj);

		Optional<Portfolio> result = portfolioRepository.findById(3L);

		assertEquals("Test Name", result.get().getPortfolioName());
		assertEquals("user8", result.get().getCreatedBy());
		assertEquals("user8", result.get().getLastMdfyBy());
		assertEquals("This is a test remark", result.get().getRemarks());
	}

	@Test
	void testUpdatePortfolio() {

		Portfolio portfolio = portfolioRepository.findById(1L).get();

		portfolio.setPortfolioName("Updated Portfolio 2");
		portfolio.setCreatedBy("user9");
		portfolio.setLastMdfyBy("user9");
		portfolio.setRemarks("Updated Remarks..");

		Portfolio result = portfolioRepository.save(portfolio);

		assertEquals(1L, result.getId());
		assertEquals("Updated Portfolio 2", result.getPortfolioName());
		assertEquals("user9", result.getCreatedBy());
		assertEquals("user9", result.getLastMdfyBy());
		assertEquals("Updated Remarks..", result.getRemarks());
	}

	@Test
	void testCountPortfolio() {
		long count = portfolioRepository.count();
		assertEquals(2, count);
	}

	@Test
	void testFindByPortfolioName() {
		String portName = "Test Portfolio 1";
		Portfolio portfolio = portfolioRepository.findByPortfolioName(portName);
		assertEquals(1, portfolio.getId());
	}

	@Test
	void testCheckPortfolioExistForUpdatePortfolio_shouldReturnCountOne() {
		Long portId = 2L;
		String portName = "Test Portfolio 1";
		Long portfolioCnt = portfolioRepository.checkPortfolioExist(portId, portName);
		assertEquals(1, portfolioCnt);
	}

	@Test
	void testCheckPortfolioExistForUpdatePortfolio_shouldReturnCountZero() {
		Long portId = 1L;
		String portName = "Test Portfolio 1";
		Long portfolioCnt = portfolioRepository.checkPortfolioExist(portId, portName);
		assertEquals(0, portfolioCnt);
	}

	@Test
	void testCheckPortfolioExistForAddPortfolio_shouldReturnCountOne() {
		String portName = "Test Portfolio 1";
		Long portfolioCnt = portfolioRepository.countByPortfolioName(portName);
		assertEquals(1, portfolioCnt);
	}

	@Test
	void testCheckPortfolioExistForAddPortfolio_shouldReturnCountZero() {
		String portName = "Test Portfolio 88";
		Long portfolioCnt = portfolioRepository.countByPortfolioName(portName);
		assertEquals(0, portfolioCnt);
	}
}
