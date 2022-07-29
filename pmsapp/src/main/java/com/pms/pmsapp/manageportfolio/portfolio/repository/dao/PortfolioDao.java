package com.pms.pmsapp.manageportfolio.portfolio.repository.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;

public interface PortfolioDao {

	void deletePortfolio(long id);

	boolean checkPortfolioExist(String portfolioName);

	boolean checkPortfolioExist(Long portfolioId, String portfolioName);

	List<Portfolio> findAll(Pageable pageable);
}
