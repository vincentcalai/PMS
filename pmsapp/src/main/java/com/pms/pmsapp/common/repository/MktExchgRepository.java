package com.pms.pmsapp.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.common.data.MktExchg;

public interface MktExchgRepository extends JpaRepository<MktExchg, String> {

	MktExchg findByMktExchgName(String stockExchg);

}
