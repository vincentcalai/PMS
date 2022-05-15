package com.pms.pmsapp.manageportfolio.portfolio.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.manageportfolio.portfolio.data.MktExchg;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioHold;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PortfolioHoldController {

	private static final Logger log = LoggerFactory.getLogger(PortfolioHoldController.class);

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@RequestMapping(value="/portfolio/hold/{id}", method=RequestMethod.GET)
	public Page<PortfolioHold> findAll(@RequestParam("page") int page, @RequestParam("size") int size,
			@PathVariable long id) {
		log.info("findAll Holds in Controller");
		Pageable pageable = PageRequest.of(page-1, size);

		List<PortfolioHold> portfolioHold= portfolioHoldService.findAllHold(id, pageable);
		long totalRec = portfolioHoldService.findAllCount(id);

		PageImpl<PortfolioHold> holdPage = new PageImpl(portfolioHold, pageable, totalRec);
		return holdPage;
	}

	@RequestMapping(value="/portfolio/hold/mktexchg", method=RequestMethod.GET)
	public List<MktExchg> findAllMktExchg() {
		log.info("findAllMktExchg Hold in Controller");
		List<MktExchg> mktExchg= portfolioHoldService.findAllMktExchg();
		return mktExchg;
	}

	@RequestMapping(value="/portfolio/hold/updateliveprices/{id}", method=RequestMethod.GET)
	public void updateLivePrices(@PathVariable long id) {
		log.info("updateLivePrices Hold in Controller");
		log.info("Update Live Price for Portfolio ID: " + id );

		List<PortfolioHold> holdList = portfolioHoldService.findAllHold(id);

		for(PortfolioHold hold : holdList) {
			String stockSym = hold.getStockSymbol();
			StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
			try {
				BigDecimal lastTransPrice = stockWrapper.getStock().getQuote(true).getPrice();
				log.info("Stock: " + stockSym + " Last Transacted Price: " + lastTransPrice);
				portfolioHoldService.computeHoldingsJob(stockSym, lastTransPrice);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}

}
