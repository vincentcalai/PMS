package com.pms.pmsapp.portfolio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import com.pms.pmsapp.TestWithSpringBoot;
import com.pms.pmsapp.fixture.PortfolioFixture;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioRepository;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioServiceImpl;
import com.pms.pmsapp.manageportfolio.portfolio.web.PortfolioForm;

@TestInstance(Lifecycle.PER_CLASS)
public class TestPortfolioServiceImpl extends TestWithSpringBoot {

	@Autowired
	private PortfolioServiceImpl portfolioServiceImpl;

	@Autowired
	private PortfolioRepository portfolioRepository;

	Portfolio portfolioObj1 = null;

	@BeforeAll
	public void setup() throws Exception {
		portfolioObj1 = PortfolioFixture.createPortfolioFixture();
		portfolioRepository.save(portfolioObj1);
	}

	@AfterAll
	public void teardown() throws Exception {
		portfolioRepository.deleteAll();
	}

	@Test
	public void testCheckPortfolioExistForAddPortfolio_ShouldReturnOneCount() {
		String portName = "Test Portfolio 1";
		Long portfolioCount = portfolioServiceImpl.checkPortfolioExist(portName);
		assertEquals(1, portfolioCount);
	}

	@Test
	public void testCheckPortfolioExistForAddPortfolio_ShouldReturnZeroCount() {
		String portName = "Any Portfolio";
		Long portfolioCount = portfolioServiceImpl.checkPortfolioExist(portName);
		assertEquals(0, portfolioCount);
	}

	@Test
	public void testCheckPortfolioExistForUpdatePortfolio_ShouldReturnOneCount() {
		Long id = 2L;
		String portName = "Test Portfolio 1";
		Long portfolioCount = portfolioServiceImpl.checkPortfolioExist(id, portName);
		assertEquals(1, portfolioCount);
	}

	@Test
	public void testCheckPortfolioExistForUpdatePortfolio_ShouldReturnZeroCount() {
		Long id = 1L;
		String portName = "Test Portfolio 1";
		Long portfolioCount = portfolioServiceImpl.checkPortfolioExist(id, portName);
		assertEquals(0, portfolioCount);
	}

	@Test
	public void testFindAllCount() {
		Long portCount = portfolioServiceImpl.findAllCount();
		assertEquals(1, portCount);
	}

	@Test
	public void testGetPortIdFromPortName() {
		String portName = "Test Portfolio 1";
		Long portId = portfolioServiceImpl.getPortIdFromPortName(portName);
		assertEquals(1, portId);
	}

	@Test
	public void testAddPortfolioSuccess() {
		PortfolioForm form = new PortfolioForm();
		form.setPortfolioName("New Portfolio");
		String username = "user1";

		form = portfolioServiceImpl.addPortfolio(form, username);
		List<Portfolio> portfolioList = portfolioRepository.findAll();
		assertEquals(2, portfolioList.size());
	}

	@Test
	public void testAddPortfolioFail() {
		PortfolioForm form = new PortfolioForm();
		form.setPortfolioName("Test Portfolio 1");
		String username = "user1";

		form = portfolioServiceImpl.addPortfolio(form, username);
		assertNotEquals("", form.getErrMsg());

		List<Portfolio> portfolioList = portfolioRepository.findAll();
		assertEquals(1, portfolioList.size());
	}
}
