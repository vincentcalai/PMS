package com.pms.pmsapp.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.common.data.Index;

@Repository
public interface IndexRepository extends JpaRepository<Index, Long> {
	// @Query("select new Index(id, idxSym, idxName, last, change, changePct,
	// lastUpdatedDt) from Index order by id asc ")
	@Query(value = "SELECT * FROM PMS_INDEX order by ID asc", nativeQuery = true)

	public List<Index> findAllIndex();
}
