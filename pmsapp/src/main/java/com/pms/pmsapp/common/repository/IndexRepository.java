package com.pms.pmsapp.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.common.data.Index;

@Repository
public interface IndexRepository extends JpaRepository<Index, Long> {

}
