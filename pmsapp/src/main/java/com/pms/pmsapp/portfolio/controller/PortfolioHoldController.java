package com.pms.pmsapp.portfolio.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.portfolio.data.MktExchg;
import com.pms.pmsapp.portfolio.data.PortfolioHold;
import com.pms.pmsapp.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.portfolio.data.StockWrapper;
import com.pms.pmsapp.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.portfolio.service.PortfolioTransService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PortfolioHoldController {
	
	private static final Logger log = LoggerFactory.getLogger(PortfolioHoldController.class);
	
	@Autowired
	private PortfolioHoldService portfolioHoldService;
	
	@RequestMapping(value="/portfolio/hold/{id}", method=RequestMethod.GET)
	public List<PortfolioHold> findAllHold(@PathVariable long id) throws IOException {
		log.info("findAll Holdings in Controller");

		List<PortfolioHold> portfolioHoldList = portfolioHoldService.findAllHold(id);
		
		return portfolioHoldList;
	}
	
	@RequestMapping(value="/portfolio/hold/mktexchg", method=RequestMethod.GET)
	public List<MktExchg> findAllMktExchg() {
		log.info("findAllMktExchg Hold in Controller");
		List<MktExchg> mktExchg= portfolioHoldService.findAllMktExchg();
		return mktExchg;
	}
	
}
