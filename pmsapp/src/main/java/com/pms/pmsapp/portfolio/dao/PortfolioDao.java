package com.pms.pmsapp.portfolio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.portfolio.data.Portfolio;

public interface PortfolioDao{
	public List<Portfolio> findAll();
	public void addPortfolio(Portfolio portfolioForm);
	public Portfolio updatePortfolio(Portfolio portfolioForm);
	public void deletePortfolio(long id);
	public boolean checkPortfolioExist(String portfolioName);
	public boolean checkPortfolioExist(Long portfolioId, String portfolioName);
}
