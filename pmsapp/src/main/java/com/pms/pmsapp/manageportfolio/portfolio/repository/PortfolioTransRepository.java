package com.pms.pmsapp.manageportfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;

public interface PortfolioTransRepository extends JpaRepository<PortfolioTrans, Long> {

}
