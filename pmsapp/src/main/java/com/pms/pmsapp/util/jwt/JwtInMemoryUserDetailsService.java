package com.pms.pmsapp.util.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.sysadmin.repository.UserRepository;
import com.pms.pmsapp.sysadmin.repository.dao.UserDao;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepository;

	private final String NO = "N";

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//        .filter(user -> user.getUsername().equals(username)).findFirst();
//		Optional<User> findFirst = userDao.findUser(username);
		Optional<User> findFirst = userRepository.findByUsernameAndDelIndOrderByIdAsc(username, NO);

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.map(JwtUserDetails::new).get();

		// return findFirst.get();
	}

}
