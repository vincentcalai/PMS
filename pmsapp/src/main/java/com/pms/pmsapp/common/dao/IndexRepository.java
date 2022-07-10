package com.pms.pmsapp.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.pmsapp.common.data.Index;

public interface IndexRepository extends JpaRepository<Index, Long> {
	@Query("select new Index(id, idxSym, idxName, last, change, changePct, lastUpdatedDt) from Index order by id asc ")
	public List<Index> findAllIndex();
}
