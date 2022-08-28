package com.pms.pmsapp.sysadmin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.sysadmin.data.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByDelInd(String delInd);

	int countByUsername(String string);

	Optional<User> findByUsernameAndDelIndOrderByIdAsc(String username, String delInd);

	List<User> findAllByDelIndOrderById(String delInd, Pageable pageable);

	long countByDelInd(String delInd);
}
