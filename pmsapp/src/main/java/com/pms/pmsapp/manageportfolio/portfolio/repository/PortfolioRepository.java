package com.pms.pmsapp.manageportfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

	Portfolio findByPortfolioName(String portfolioName);

	@Query(value = "SELECT count(*) FROM PMS_PORT where port_name = :portfolioName and id <> :id", nativeQuery = true)
	Long checkPortfolioExist(@Param("id") Long portfolioId, @Param("portfolioName") String portfolioName);

	Long countByPortfolioName(String portfolioName);
}
