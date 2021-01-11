package com.pms.pmsapp.portfolio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.portfolio.data.Portfolio;
import com.pms.pmsapp.portfolio.service.PortfolioService;
import com.pms.pmsapp.util.jwt.JwtUserDetails;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PortfolioController {
	
	private static final Logger log = LoggerFactory.getLogger(PortfolioController.class);
	
	@Autowired
	private PortfolioService portfolioService;
	
	@RequestMapping(value="/portfolio", method=RequestMethod.GET)
	public List<Portfolio> findAll() {
		log.info("findAll in Controller");
		List<Portfolio> portfolio= portfolioService.findAll();
		return portfolio;
	}
	
	@RequestMapping(value="portfolio/add", method=RequestMethod.POST)
	public Portfolio addPortfolio(@RequestBody Portfolio portfolioForm, Authentication authentication) {
		 boolean portfolioExist = false;
		 String portfolioName = portfolioForm.getPortfolioName();
		 
		 String username = authentication.getName();
		 
		 if(username != null) {
			 portfolioForm.setCreatedBy(username);
			 portfolioForm.setLastMdfyBy(username);
		 }
		 
		 log.info("addPortfolio in Controller.. ");
		 log.info("portfolioForm:  " + portfolioName);
		 
		 portfolioExist = portfolioService.checkPortfolioExist(portfolioName);
		 if(portfolioExist) {
			 portfolioForm.setErrMsg("Portfolio name already exist. Please create portfolio with different name.");
		 } else {
			 portfolioService.addPortfolio(portfolioForm);
			 portfolioForm.setSystemMsg("Portfolio added Successfully.");
		 }
		 return portfolioForm;
	}
	
	@RequestMapping(value="portfolio/update/{id}", method=RequestMethod.PUT)
	public Portfolio updatePortfolio(@PathVariable long id, @RequestBody Portfolio portfolioForm, Authentication authentication) {
		 log.info("updatePortfolio in Controller.. ");
		 
		 boolean portfolioExist = false;
		 Long portfolioId = portfolioForm.getId();
		 String portfolioName = portfolioForm.getPortfolioName();
		 String username = authentication.getName();
		 
		 if(username != null) {
			 portfolioForm.setCreatedBy(username);
			 portfolioForm.setLastMdfyBy(username);
		 }
		 
		 portfolioExist = portfolioService.checkPortfolioExist(portfolioId, portfolioName);
		 
		 if(portfolioExist) {
			 portfolioForm.setErrMsg("Portfolio name already exist. Please update portfolio with different name.");
		 } else {
			 portfolioForm = portfolioService.updatePortfolio(portfolioForm);
			 portfolioForm.setSystemMsg("Portfolio updated successfully.");
		 }
		 return portfolioForm;
	}
	
	@RequestMapping(value="portfolio/delete/{id}", method=RequestMethod.DELETE)
	public Portfolio deletePortfolio(@PathVariable long id) {
		Portfolio portfolio = new Portfolio();
		log.info("deletePortfolio in Controller");
		portfolioService.deletePortfolio(id);
		
		portfolio.setSystemMsg("Portfolio deleted successfully.");
		
		return portfolio;
	}
	
}
