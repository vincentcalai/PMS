package com.pms.pmsapp.portfolio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import com.pms.pmsapp.TestWithSpringBoot;
import com.pms.pmsapp.fixture.PortfolioFixture;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioRepository;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioServiceImpl;
import com.pms.pmsapp.manageportfolio.portfolio.web.PortfolioForm;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class TestPortfolioServiceImpl extends TestWithSpringBoot {

	@Autowired
	private PortfolioServiceImpl portfolioServiceImpl;

	@Autowired
	private PortfolioRepository portfolioRepository;

	@BeforeAll
	public void setup() throws Exception {
		List<Portfolio> list = PortfolioFixture.createPortfolioFixture();
		portfolioRepository.saveAll(list);
	}

	@AfterAll
	public void teardown() throws Exception {
		portfolioRepository.deleteAll();
	}

	@Test
	@Order(1)
	public void testCheckPortfolioExistForAddPortfolio_ShouldReturnOneCount() {
		String portName = "Test Portfolio 1";
		Long portfolioCount = portfolioServiceImpl.checkPortfolioExist(portName);
		assertEquals(1, portfolioCount);
	}

	@Test
	@Order(2)
	public void testCheckPortfolioExistForAddPortfolio_ShouldReturnZeroCount() {
		String portName = "Any Portfolio";
		Long portfolioCount = portfolioServiceImpl.checkPortfolioExist(portName);
		assertEquals(0, portfolioCount);
	}

	@Test
	@Order(3)
	public void testCheckPortfolioExistForUpdatePortfolio_ShouldReturnOneCount() {
		Long id = 2L;
		String portName = "Test Portfolio 1";
		Long portfolioCount = portfolioServiceImpl.checkPortfolioExist(id, portName);
		assertEquals(1, portfolioCount);
	}

	@Test
	@Order(4)
	public void testCheckPortfolioExistForUpdatePortfolio_ShouldReturnZeroCount() {
		Long id = 1L;
		String portName = "Test Portfolio 1";
		Long portfolioCount = portfolioServiceImpl.checkPortfolioExist(id, portName);
		assertEquals(0, portfolioCount);
	}

	@Test
	@Order(5)
	public void testFindAllCount() {
		Long portCount = portfolioServiceImpl.findAllCount();
		assertEquals(2, portCount);
	}

	@Test
	@Order(6)
	public void testGetPortIdFromPortName() {
		String portName = "Test Portfolio 1";
		Long portId = portfolioServiceImpl.getPortIdFromPortName(portName);
		assertEquals(1, portId);
	}

	@Test
	@Order(7)
	public void testAddPortfolioSuccess() {
		PortfolioForm form = new PortfolioForm();
		form.setPortfolioName("New Portfolio");
		String username = "user1";

		form = portfolioServiceImpl.addPortfolio(form, username);
		assertNotEquals("", form.getSystemMsg());

		List<Portfolio> portfolioList = portfolioRepository.findAll();
		assertEquals(3, portfolioList.size());
	}

	@Test
	@Order(8)
	public void testAddPortfolioFail() {
		PortfolioForm form = new PortfolioForm();
		form.setPortfolioName("Test Portfolio 1");
		String username = "user1";

		form = portfolioServiceImpl.addPortfolio(form, username);
		assertNotEquals("", form.getErrMsg());

		List<Portfolio> portfolioList = portfolioRepository.findAll();
		assertEquals(3, portfolioList.size());
	}

	@Test
	@Order(9)
	public void testUpdatePortfolioFail() {
		PortfolioForm form = new PortfolioForm();
		form.setId(1L);
		form.setPortfolioName("Test Portfolio 2");
		form.setCreatedBy("user1");
		form.setCreatedDate(new Date());
		form.setLastMdfyBy("user1");
		form.setRemarks("Updated Remarks");
		String username = "user1";

		form = portfolioServiceImpl.updatePortfolio(form, username);
		assertNotEquals("", form.getErrMsg());

		Portfolio firstPortfolio = portfolioRepository.findById(1L).get();
		String newPortfolioName = firstPortfolio.getPortfolioName();
		String newPortfolioRemarks = firstPortfolio.getRemarks();
		assertEquals("Test Portfolio 1", newPortfolioName);
		assertEquals("This is a test remark 1", newPortfolioRemarks);
	}

	@Test
	@Order(10)
	public void testUpdatePortfolioSuccess() {
		PortfolioForm form = new PortfolioForm();
		form.setId(1L);
		form.setPortfolioName("New Updated Portfolio");
		form.setCreatedBy("user1");
		form.setCreatedDate(new Date());
		form.setLastMdfyBy("user1");
		form.setRemarks("Updated Remarks");
		String username = "user1";

		form = portfolioServiceImpl.updatePortfolio(form, username);
		assertNotEquals("", form.getSystemMsg());

		List<Portfolio> portfolioList = portfolioRepository.findAll();
		String newPortfolioName = portfolioList.get(0).getPortfolioName();
		String newPortfolioRemarks = portfolioList.get(0).getRemarks();
		assertEquals("New Updated Portfolio", newPortfolioName);
		assertEquals("Updated Remarks", newPortfolioRemarks);

		form.setPortfolioName("New Updated Portfolio");
	}

}
