package com.pms.pmsapp.portfolio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.pms.pmsapp.TestWithSpringBoot;
import com.pms.pmsapp.common.data.MktExchg;
import com.pms.pmsapp.common.repository.MktExchgRepository;
import com.pms.pmsapp.fixture.MktExchgFixture;
import com.pms.pmsapp.fixture.PortfolioTransFixture;
import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioTransRepository;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioTransServiceImpl;

import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class TestPortfolioTransServiceImp extends TestWithSpringBoot {

	@InjectMocks
	@Autowired
	private PortfolioTransServiceImpl portfolioTransServiceImpl;

	@Autowired
	private PortfolioTransRepository portfolioTransRepository;

	@Autowired
	private MktExchgRepository mktExchgRepository;

	@Mock
	PortfolioHoldService portfolioHoldService;

	@Mock
	DividendService dividendService;

	@Mock
	StockWrapper stockWrapper;

	PortfolioTrans portfolioTransSaveObj;

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

		boolean foundSGX = mktExchgList.stream().anyMatch(mktExchg -> mktExchg.getMktExchgName() == "SGX");
		assertTrue(foundSGX);

		boolean foundNYSE = mktExchgList.stream().anyMatch(mktExchg -> mktExchg.getMktExchgName() == "NYSE");
		assertTrue(foundNYSE);

		boolean foundHKEX = mktExchgList.stream().anyMatch(mktExchg -> mktExchg.getMktExchgName() == "HKEX");
		assertTrue(foundHKEX);

		boolean foundOTC = mktExchgList.stream().anyMatch(mktExchg -> mktExchg.getMktExchgName() == "OTC");
		assertTrue(foundOTC);

		boolean foundNASDAQ = mktExchgList.stream().anyMatch(mktExchg -> mktExchg.getMktExchgName() == "NASDAQ");
		assertTrue(foundNASDAQ);
	}

	@Test
	@Order(2)
	public void testAddPortfolioTrans() {
		portfolioTransSaveObj = new PortfolioTrans();

		portfolioTransSaveObj.setPortId(1L);
		portfolioTransSaveObj.setStockName("JPMorgan Chase & Co.");
		portfolioTransSaveObj.setStockSymbol("JPM");
		portfolioTransSaveObj.setStockExchg("NYSE");
		portfolioTransSaveObj.setNoOfShare(100);
		portfolioTransSaveObj.setTransPrice(new BigDecimal("115.3618674"));
		portfolioTransSaveObj.setAction("B");
		portfolioTransSaveObj.setBackDatedDate(null);
		portfolioTransSaveObj.setCreatedBy("user1");
		portfolioTransSaveObj.setCreatedDt(new Date());
		portfolioTransSaveObj.setRemarks("Saved transaction as ID 3");
		portfolioTransSaveObj.setCurrentStockHold(80);

		portfolioTransServiceImpl.addPortfolioTrans(portfolioTransSaveObj);

		PortfolioTrans retrievedPortfolio = portfolioTransRepository.findById(3L).get();
		assertNotNull(retrievedPortfolio);

		assertEquals(2, retrievedPortfolio.getTransPrice().scale());
		assertEquals(new BigDecimal("11536.19"), retrievedPortfolio.getTotalAmt());
	}

	@Test
	@Order(3)
	public void testDeletePortfolioTrans() {

		portfolioTransServiceImpl.deletePortfolioTrans(3L);

		List<PortfolioTrans> portfolioTransList = portfolioTransRepository.findAll();

		assertEquals(2, portfolioTransList.size());
	}

	@Test
	@Order(4)
	public void testPopulateToHolding() {

		portfolioTransServiceImpl.populateToHolding(1L, 1L);

	}

	@Test
	@Order(5)
	public void testFindSuffix() {
		String nasdaqSuffix = portfolioTransServiceImpl.findSuffix("NASDAQ");
		String nyseSuffix = portfolioTransServiceImpl.findSuffix("NYSE");
		String otcSuffix = portfolioTransServiceImpl.findSuffix("OTC");
		String hkexSuffix = portfolioTransServiceImpl.findSuffix("HKEX");
		String sgxSuffix = portfolioTransServiceImpl.findSuffix("SGX");

		assertEquals(null, nasdaqSuffix);
		assertEquals(null, nyseSuffix);
		assertEquals(null, otcSuffix);
		assertEquals(".HK", hkexSuffix);
		assertEquals(".SI", sgxSuffix);
	}

	@Test
	@Order(6)
	public void testFindAllCount() {
		long count = portfolioTransServiceImpl.findAllCount(1L);

		assertEquals(1, count);
	}

	@Test
	@Order(7)
	void testSearchTransCount_WhenSearchUsingStockSym_ShouldReturnOneCount() {
		Long portId = 1L;
		Long count = portfolioTransServiceImpl.searchTransCount(portId, "MSFT");
		assertEquals(1, count);
	}

	@Test
	@Order(8)
	void testSearchTransCount_WhenSearchUsingStockName_ShouldReturnOneCount() {
		Long portId = 1L;
		Long count = portfolioTransServiceImpl.searchTransCount(portId, "MICRO");
		assertEquals(1, count);
	}

	@Test
	@Order(9)
	void testSearchTransCount_WhenSearchUsingStockSym_ShouldReturnZeroCount() {
		Long portId = 1L;
		Long count = portfolioTransServiceImpl.searchTransCount(portId, "AMZN");
		assertEquals(0, count);
	}

	@Test
	@Order(10)
	void testSearchTransCount_WhenSearchUsingStockName_ShouldReturnZeroCount() {
		Long portId = 1L;
		Long count = portfolioTransServiceImpl.searchTransCount(portId, "AMA");
		assertEquals(0, count);
	}

	@Test
	@Order(11)
	void testRetrieveStockInfo() throws IOException {

		Stock stock = new Stock("MSFT");
		stock.setStockExchange("NasdaqGS");
		stock.setName("Microsoft Corp.");
		StockQuote stockQuote = new StockQuote("MSFT");
		stock.setQuote(stockQuote);
		StockWrapper dummyStockWrapper = new StockWrapper(stock);

		when(portfolioHoldService.findStock(anyString())).thenReturn(dummyStockWrapper);

		PortfolioTrans portfolioTransObj = new PortfolioTrans();
		portfolioTransObj.setStockSymbol("MSFT");

		PortfolioTrans result = portfolioTransServiceImpl.retrieveStockInfo(portfolioTransObj);

		assertEquals("Microsoft Corp.", result.getStockName());
		assertEquals("NASDAQ", result.getStockExchg());
		assertNotNull(result.getTransPrice());
	}

	@Test
	@Order(12)
	void testAddPortfolioTrans_buySuccess() {

		Stock stock = new Stock("MSFT");
		stock.setStockExchange("NasdaqGS");
		stock.setName("Microsoft Corp.");
		StockQuote stockQuote = new StockQuote("MSFT");
		stockQuote.setPrice(new BigDecimal("280.04"));
		stock.setQuote(stockQuote);
		StockWrapper dummyStockWrapper = new StockWrapper(stock);

		when(portfolioHoldService.findStock(anyString())).thenReturn(dummyStockWrapper);

		Long portId = 2L;
		String username = "user1";

		PortfolioTrans portfolioTransObj = new PortfolioTrans();
		portfolioTransObj.setStockName("Microsoft Corp.");
		portfolioTransObj.setAction("BUY");
		portfolioTransObj.setNoOfShare(80);
		portfolioTransObj.setStockSymbol("MSFT");
		portfolioTransObj.setStockExchg("NASDAQ");
		portfolioTransObj.setTransPrice(new BigDecimal("269.81"));

		PortfolioTrans result = portfolioTransServiceImpl.addPortfolioTrans(portfolioTransObj, 0, username);

		verify(portfolioHoldService, times(1)).computeHoldingsJob(anyString(), any(BigDecimal.class));

		assertNotNull(result.getSystemMsg());
		assertNull(result.getErrMsg());
	}

	@Test
	@Order(13)
	void testAddPortfolioTrans_unknownStockSym_buyFail() {

		Stock stock = null;
		StockWrapper dummyStockWrapper = new StockWrapper(stock);

		when(portfolioHoldService.findStock(anyString())).thenReturn(dummyStockWrapper);

		Long portId = 2L;
		String username = "user1";

		PortfolioTrans portfolioTransObj = new PortfolioTrans();
		portfolioTransObj.setStockName("Microsoft Corp.");
		portfolioTransObj.setAction("BUY");
		portfolioTransObj.setNoOfShare(60);
		portfolioTransObj.setStockSymbol("MSFT");
		portfolioTransObj.setStockExchg("NASDAQ");
		portfolioTransObj.setTransPrice(new BigDecimal("269.81"));

		PortfolioTrans result = portfolioTransServiceImpl.addPortfolioTrans(portfolioTransObj, 0, username);

		verify(portfolioHoldService, times(0)).computeHoldingsJob(anyString(), any(BigDecimal.class));

		assertNull(result.getSystemMsg());
		assertEquals("Stock Symbol is invalid, unable to get stock price. Save transaction failed.",
				result.getErrMsg());
	}

	@Test
	@Order(14)
	void testAddPortfolioTrans_insufficientShares_buyFail() {

		Long portId = 2L;
		String username = "user1";

		PortfolioTrans portfolioTransObj = new PortfolioTrans();
		portfolioTransObj.setStockName("Microsoft Corp.");
		portfolioTransObj.setAction("BUY");
		portfolioTransObj.setNoOfShare(0);
		portfolioTransObj.setStockSymbol("MSFT");
		portfolioTransObj.setStockExchg("NASDAQ");
		portfolioTransObj.setTransPrice(new BigDecimal("269.81"));

		PortfolioTrans result = portfolioTransServiceImpl.addPortfolioTrans(portfolioTransObj, 0, username);

		verify(portfolioHoldService, times(0)).computeHoldingsJob(anyString(), any(BigDecimal.class));

		assertNull(result.getSystemMsg());
		assertEquals("Invalid No. Of Share. No. Of Share should be more than 0. Save transaction failed.",
				result.getErrMsg());
	}

}
