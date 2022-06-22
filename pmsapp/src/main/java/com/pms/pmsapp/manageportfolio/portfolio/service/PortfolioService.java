package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;

public interface PortfolioService{
	List<Portfolio> findAll(Pageable pageable);
	Portfolio updatePortfolio(Portfolio portfolioForm, String username);
	void deletePortfolio(long id);
	boolean checkPortfolioExist(String portfolioName);
	boolean checkPortfolioExist(Long portfolioId, String portfolioName);
	long findAllCount();
	long getPortIdFromPortName(String portfolioName);
	Portfolio addPortfolio(Portfolio portfolioForm, String username);
}
