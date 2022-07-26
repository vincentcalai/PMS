package com.pms.pmsapp.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.common.data.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findByUsernameOrderByGenDtDesc(String username);

	int countByUsernameAndDelInd(String loginUser, String delInd);

	List<Message> findByUsername(String loginUser);

	void deleteByUsername(String loginUser);
}
