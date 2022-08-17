package com.pms.pmsapp.sysadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.sysadmin.data.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByDelInd(String indNo);

}
