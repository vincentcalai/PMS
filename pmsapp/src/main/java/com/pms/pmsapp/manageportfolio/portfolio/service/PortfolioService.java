package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.web.PortfolioForm;

public interface PortfolioService {
	List<Portfolio> findAll(Pageable pageable);

	PortfolioForm updatePortfolio(PortfolioForm portfolioForm, String username);

	void deletePortfolio(long id);

	boolean checkPortfolioExist(String portfolioName);

//	boolean checkPortfolioExist(Long portfolioId, String portfolioName);

	Long checkPortfolioExist(Long portfolioId, String portfolioName);

	long findAllCount();

	long getPortIdFromPortName(String portfolioName);

	PortfolioForm addPortfolio(PortfolioForm portfolioForm, String username);
}
