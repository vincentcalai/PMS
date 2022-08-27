package com.pms.pmsapp.sysadmin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.sysadmin.data.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByDelInd(String indNo);

	int countByUsername(String string);

	Optional<User> findByUsernameAndDelIndOrderByIdAsc(String username, String delInd);

}
