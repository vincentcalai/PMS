package com.pms.pmsapp.common;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.common.service.HomeService;
import com.pms.pmsapp.common.web.HomeForm;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.quotes.stock.StockQuote;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public HomeForm findAll() {
		HomeForm homeList = new HomeForm();
		log.info("findAll in Controller");
		List<Index> indexList= homeService.findAllIndex();
		List<Forex> forexList = homeService.findAllForex();
		homeList.setIndexList(indexList);
		homeList.setForexList(forexList);
		return homeList;
	}

	@RequestMapping(value="/home/updateliveprices", method=RequestMethod.GET)
	public void updateLivePrices() {
		log.info("updateLivePrices in Controller");

		homeService.updateLivePrices();
	}
}
