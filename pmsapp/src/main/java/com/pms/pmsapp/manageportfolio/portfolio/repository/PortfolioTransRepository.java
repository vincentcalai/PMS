package com.pms.pmsapp.manageportfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;

public interface PortfolioTransRepository extends JpaRepository<PortfolioTrans, Long> {
	@Query(value = "SELECT SQ_PMS_PORT_TRANS.nextval FROM DUAL", nativeQuery = true)
	Long getNextTransID();

	Long countByPortId(Long portId);

	@Query(value = "SELECT count(*) FROM PMS_PORT_TRANS where port_id = :portId and "
			+ "(UPPER(stock_nam) like '%' || :searchText || '%' or stock_sym like :searchText)", nativeQuery = true)
	Long searchTransCount(@Param("portId") Long portId, @Param("searchText") String searchText);
}
