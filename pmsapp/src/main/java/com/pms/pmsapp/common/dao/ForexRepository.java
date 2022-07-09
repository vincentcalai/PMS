package com.pms.pmsapp.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.common.data.Forex;

public interface ForexRepository extends JpaRepository<Forex, Long> {

}
