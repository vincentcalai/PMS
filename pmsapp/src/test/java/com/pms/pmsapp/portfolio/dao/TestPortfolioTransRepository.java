package com.pms.pmsapp.portfolio.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.fixture.PortfolioTransFixture;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioTransRepository;
import com.pms.pmsapp.manageportfolio.portfolio.repository.dao.PortfolioTransDaoImpl;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@ContextConfiguration(classes = { PortfolioTransDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
class TestPortfolioTransRepository {

	@Autowired
	private PortfolioTransRepository portfolioTransRepository;

	@Autowired
	private PortfolioTransDaoImpl portfolioTransDaoImpl;

	PortfolioTrans portfolioTransSaveObj = null;

	@BeforeAll
	private void setup() {
		List<PortfolioTrans> list = PortfolioTransFixture.createPortfolioTransFixture();
		portfolioTransRepository.saveAll(list);
	}

	@AfterAll
	private void tearDown() {
		portfolioTransRepository.deleteAll();
	}

	@Test
	@Order(1)
	void testSavePortfolioTrans() {

		portfolioTransSaveObj = new PortfolioTrans();

		portfolioTransSaveObj.setId(3L);
		portfolioTransSaveObj.setPortId(1L);
		portfolioTransSaveObj.setStockName("JPMorgan Chase & Co.");
		portfolioTransSaveObj.setStockSymbol("JPM");
		portfolioTransSaveObj.setStockExchg("NYSE");
		portfolioTransSaveObj.setNoOfShare(100);
		portfolioTransSaveObj.setTransPrice(new BigDecimal("115.36"));
		portfolioTransSaveObj.setTotalAmt(new BigDecimal("11536"));
		portfolioTransSaveObj.setAction("B");
		// portfolioTransSaveObj.setBackDatedDate(null);
		portfolioTransSaveObj.setCreatedBy("user1");
		portfolioTransSaveObj.setCreatedDt(new Date());
		portfolioTransSaveObj.setRemarks("Saved transaction as ID 3");
		// portfolioTransSaveObj.setCurrentStockHold(80);

		portfolioTransRepository.save(portfolioTransSaveObj);

		Optional<PortfolioTrans> result = portfolioTransRepository.findById(3L);

		assertEquals("JPMorgan Chase & Co.", result.get().getStockName());
		assertEquals("JPM", result.get().getStockSymbol());
		assertEquals(new BigDecimal("115.36"), result.get().getTransPrice());
		assertEquals(new BigDecimal("11536"), result.get().getTotalAmt());
		assertEquals("B", result.get().getAction());
		// assertEquals(80, result.get().getCurrentStockHold());
	}

	@Test
	@Order(2)
	void testDeletePortfolioTrans() {

		portfolioTransRepository.deleteById(2L);

		List<PortfolioTrans> result = portfolioTransRepository.findAll();

		assertEquals(1, result.size());
	}

	@Test
	@Order(3)
	void testGetNextTransID() {
		Long id = portfolioTransRepository.getNextTransID();
		assertNotNull(id);
		assertEquals(4, id);
	}

	@Test
	@Order(4)
	void testfindAllCountByPortId() {
		Long portId = 1L;
		Long count = portfolioTransRepository.countByPortId(portId);
		assertEquals(1, count);
	}

	@Test
	@Order(5)
	void testSearchTransCount_WhenSearchUsingStockSym_ShouldReturnOneCount() {
		Long portId = 1L;
		String searchText = "MSFT";
		searchText = "%" + searchText + "%";
		Long count = portfolioTransRepository.searchTransCount(portId, "MSFT");
		assertEquals(1, count);
	}

	@Test
	@Order(6)
	void testSearchTransCount_WhenSearchUsingStockName_ShouldReturnOneCount() {
		Long portId = 1L;
		String searchText = "MICRO";
		searchText = "%" + searchText + "%";
		Long count = portfolioTransRepository.searchTransCount(portId, searchText);
		assertEquals(1, count);
	}

	@Test
	@Order(7)
	void testSearchTransCount_WhenSearchUsingStockSym_ShouldReturnZeroCount() {
		Long portId = 1L;
		String searchText = "AMZN";
		searchText = "%" + searchText + "%";
		Long count = portfolioTransRepository.searchTransCount(portId, "AMZN");
		assertEquals(0, count);
	}

	@Test
	@Order(7)
	void testSearchTransCount_WhenSearchUsingStockName_ShouldReturnZeroCount() {
		Long portId = 1L;
		String searchText = "AMA";
		searchText = "%" + searchText + "%";
		Long count = portfolioTransRepository.searchTransCount(portId, "AMA");
		assertEquals(0, count);
	}

}
