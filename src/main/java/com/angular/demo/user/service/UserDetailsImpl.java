package com.angular.demo.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.angular.demo.user.model.User;

public interface UserDetailsImpl extends UserDetailsService {
	void save(User user);
}
