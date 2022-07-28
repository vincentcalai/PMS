package com.pms.pmsapp.manageportfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
