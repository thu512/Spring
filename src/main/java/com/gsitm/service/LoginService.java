package com.gsitm.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gsitm.controller.LoginController;
import com.gsitm.dao.UserDao;
import com.gsitm.vo.UserVO;

public class LoginService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Resource(name = "userDao")
	private UserDao userDao;


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("username="+username);
		//dao에서 user 검증
		UserVO user2 = userDao.getUser(username);
		//validation
		if (username == null) {
			throw new UsernameNotFoundException("No user found with username");
		}

		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(user2.getRn()));

		UserDetails user = new User(user2.getId(), user2.getPwd(),roles );
		
		return user;

	}

}