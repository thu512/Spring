package com.gsitm.service;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gsitm.controller.LoginController;

public class LoginService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("username="+username);
		//dao에서 user 검증
		
		//validation
		if (username == null) {
			throw new UsernameNotFoundException("No user found with username");
		}

		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));

		UserDetails user = new User(username, "1234", roles);

		return user;

	}

}