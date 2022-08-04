package com.pms.pmsapp.portfolio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import com.pms.pmsapp.common.data.MktExchg;
import com.pms.pmsapp.common.repository.MktExchgRepository;
import com.pms.pmsapp.fixture.MktExchgFixture;
import com.pms.pmsapp.fixture.PortfolioTransFixture;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioTransRepository;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioTransServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class TestPortfolioTransServiceImp extends TestWithSpringBoot {

	@Autowired
	private PortfolioTransServiceImpl portfolioTransServiceImpl;

	@Autowired
	private PortfolioTransRepository portfolioTransRepository;

	@Autowired
	private MktExchgRepository mktExchgRepository;

	@BeforeAll
	public void setup() throws Exception {
		List<PortfolioTrans> portfolioTransList = PortfolioTransFixture.createPortfolioTransFixture();
		portfolioTransRepository.saveAll(portfolioTransList);

		List<MktExchg> mktExchgList = MktExchgFixture.createMktExchgListFixture();
		mktExchgRepository.saveAll(mktExchgList);
	}

	@AfterAll
	public void teardown() throws Exception {
		portfolioTransRepository.deleteAll();
		mktExchgRepository.deleteAll();
	}

	@Test
	@Order(1)
	public void testFindAllMktExchg() {
		List<MktExchg> mktExchgList = portfolioTransServiceImpl.findAllMktExchg();
		assertEquals(5, mktExchgList.size());

		boolean foundNYSE = mktExchgList.stream().anyMatch(mktExchg -> mktExchg.getMktExchgName() == "NYSE");
		assertTrue(foundNYSE);

		boolean foundNASDAQ = mktExchgList.stream().anyMatch(mktExchg -> mktExchg.getMktExchgName() == "NASDAQ");
		assertTrue(foundNASDAQ);
	}

}
