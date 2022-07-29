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

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioService;
import com.pms.pmsapp.manageportfolio.portfolio.web.PortfolioForm;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PortfolioController {

	private static final Logger log = LoggerFactory.getLogger(PortfolioController.class);

	@Autowired
	private PortfolioService portfolioService;

	@RequestMapping(value = "/portfolio", method = RequestMethod.GET)
	public Page<Portfolio> findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
		log.info("findAll in Controller");
		Pageable pageable = PageRequest.of(page - 1, size);

		List<Portfolio> portfolioList = portfolioService.findAll(pageable);
		long totalRec = portfolioService.findAllCount();

		PageImpl<Portfolio> portfolioPage = new PageImpl(portfolioList, pageable, totalRec);
		return portfolioPage;
	}

	@RequestMapping(value = "portfolio/add", method = RequestMethod.POST)
	public PortfolioForm addPortfolio(@RequestBody PortfolioForm portfolioForm, Authentication authentication) {

		String username = authentication.getName();

		return portfolioService.addPortfolio(portfolioForm, username);
	}

	@RequestMapping(value = "portfolio/update/{id}", method = RequestMethod.PUT)
	public PortfolioForm updatePortfolio(@PathVariable long id, @RequestBody PortfolioForm portfolioForm,
			Authentication authentication) {
		log.info("updatePortfolio in Controller.. ");

		String username = authentication.getName();

		return portfolioService.updatePortfolio(portfolioForm, username);
	}

	@RequestMapping(value = "portfolio/delete/{id}", method = RequestMethod.DELETE)
	public PortfolioForm deletePortfolio(@PathVariable long id) {
		PortfolioForm portfolioForm = new PortfolioForm();
		log.info("deletePortfolio in Controller");
		portfolioService.deletePortfolio(id);

		portfolioForm.setSystemMsg("Portfolio deleted successfully.");

		return portfolioForm;
	}

}
