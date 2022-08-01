package com.pms.pmsapp.portfolio.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
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
import com.pms.pmsapp.fixture.PortfolioTransFixture;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioTransRepository;
import com.pms.pmsapp.manageportfolio.portfolio.repository.dao.PortfolioTransDaoImpl;

@DataJpaTest
@ContextConfiguration(classes = { PortfolioTransDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
class TestPortfolioTransRepository {

	@Autowired
	private PortfolioTransRepository portfolioTransRepository;

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
		portfolioTransSaveObj.setBackDatedDate(null);
		portfolioTransSaveObj.setCreatedBy("user1");
		portfolioTransSaveObj.setCreatedDt(new Date());
		portfolioTransSaveObj.setRemarks("Saved transaction as ID 3");
		portfolioTransSaveObj.setCurrentStockHold(80);

		portfolioTransRepository.save(portfolioTransSaveObj);

		Optional<PortfolioTrans> result = portfolioTransRepository.findById(3L);

		assertEquals("JPMorgan Chase & Co.", result.get().getStockName());
		assertEquals("JPM", result.get().getStockSymbol());
		assertEquals(new BigDecimal("115.36"), result.get().getTransPrice());
		assertEquals(new BigDecimal("11536"), result.get().getTotalAmt());
		assertEquals("B", result.get().getAction());
		assertEquals(80, result.get().getCurrentStockHold());
	}

}
