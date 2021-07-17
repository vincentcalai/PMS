package com.pms.pmsapp.util.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.sysadmin.dao.UserDao;
import com.pms.pmsapp.sysadmin.data.User;





@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//        .filter(user -> user.getUsername().equals(username)).findFirst();
	Optional<User> findFirst = userDao.findUser(username);
	  

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }
    
    return findFirst.map(JwtUserDetails::new).get();

    //return findFirst.get();
  }

}


