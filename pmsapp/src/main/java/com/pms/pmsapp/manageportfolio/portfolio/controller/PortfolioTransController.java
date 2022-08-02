package com.pms.pmsapp.manageportfolio.portfolio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.common.data.MktExchg;
import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioTransService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PortfolioTransController {

	private static final Logger log = LoggerFactory.getLogger(PortfolioTransController.class);

	@Autowired
	private PortfolioTransService portfolioTransService;

	@Autowired
	private DividendService dividendService;

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@RequestMapping(value = "/portfolio/transaction/{portId}", method = RequestMethod.GET)
	public Page<PortfolioTrans> findAll(@RequestParam("page") int page, @RequestParam("size") int size,
			@PathVariable long portId) {
		log.info("findAll Trans in Controller");

		Pageable pageable = PageRequest.of(page - 1, size);
		int currentStockHold = 0;

		List<PortfolioTrans> portfolioTrans = portfolioTransService.findAll(portId, pageable);
		long totalRec = portfolioTransService.findAllCount(portId);

		for (int i = 0; i < portfolioTrans.size(); i++) {
			currentStockHold = portfolioTransService.findCurrentStockHold(portfolioTrans.get(i));
			portfolioTrans.get(i).setCurrentStockHold(currentStockHold);
		}

		PageImpl<PortfolioTrans> transPage = new PageImpl(portfolioTrans, pageable, totalRec);
		return transPage;
	}

	@RequestMapping(value = "/portfolio/transaction/search/{portId}", method = RequestMethod.POST)
	public Page<PortfolioTrans> searchTrans(@RequestParam("page") int page, @RequestParam("size") int size,
			@PathVariable long portId, @RequestBody(required = false) String searchText) {
		log.info("searchText Trans in Controller");
		log.info("searchText: " + searchText);

		Pageable pageable = PageRequest.of(page - 1, size);
		int currentStockHold = 0;

		if (searchText == null || "".equals(searchText)) {
			searchText = "%";
		} else {
			searchText = searchText + "%";
		}

		List<PortfolioTrans> portfolioTrans = portfolioTransService.searchTrans(portId, searchText, pageable);
		long totalRec = portfolioTransService.searchTransCount(portId, searchText);

		for (int i = 0; i < portfolioTrans.size(); i++) {
			currentStockHold = portfolioTransService.findCurrentStockHold(portfolioTrans.get(i));
			portfolioTrans.get(i).setCurrentStockHold(currentStockHold);
		}

		PageImpl<PortfolioTrans> transPage = new PageImpl(portfolioTrans, pageable, totalRec);
		return transPage;
	}

	@RequestMapping(value = "/portfolio/transaction/mktexchg", method = RequestMethod.GET)
	public List<MktExchg> findAllMktExchg() {
		log.info("findAllMktExchg Trans in Controller");
		return portfolioTransService.findAllMktExchg();
	}

	@RequestMapping(value = "/portfolio/transaction/stockhold", method = RequestMethod.POST)
	public int findCurrentStockHold(@RequestBody PortfolioTrans portfolioTrans) {
		log.info("findCurrentStockHold Trans in Controller");
		return portfolioTransService.findCurrentStockHold(portfolioTrans);
	}

	@RequestMapping(value = "/portfolio/retrieveStockInfo", method = RequestMethod.POST)
	public PortfolioTrans retrieveStockInfo(@RequestBody PortfolioTrans portfolioTrans) {
		log.info("retrieveStockInfo Trans in Controller");

		return portfolioTransService.retrieveStockInfo(portfolioTrans);
	}

	@RequestMapping(value = "/portfolio/transaction/add/{portId}", method = RequestMethod.POST)
	public PortfolioTrans addTrans(@RequestBody PortfolioTrans portfolioTrans, @PathVariable long portId,
			Authentication authentication) {
		log.info("addPortfolioTrans in Controller.. ");
		log.info("portId:  " + portId);

		String username = authentication.getName();

		return portfolioTransService.addPortfolioTrans(portfolioTrans, portId, username);

	}

}
