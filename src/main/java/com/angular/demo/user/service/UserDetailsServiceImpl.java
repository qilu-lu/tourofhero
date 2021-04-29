package com.angular.demo.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.angular.demo.user.exception.UserDejaExisteException;
import com.angular.demo.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsImpl {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.angular.demo.user.model.User user = userRepo.findByName(username);
		if (user != null) {
			return new User(username, user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	public UserDetails creerUser(String username, String email, String password) throws UserDejaExisteException {

		com.angular.demo.user.model.User user = userRepo.findByName(username);
		if (user == null) {
			com.angular.demo.user.model.User user2 = new com.angular.demo.user.model.User();
			user2.setUsername(username);
			user2.setEmail(email);
			user2.setPassword(passwordEncoder.encode(password));
			userRepo.save(user2);
			return new User(user2.getUsername(), user2.getPassword(), new ArrayList<>());
		} else {
			throw new UserDejaExisteException("User  username: " + username + "existe deja");
		}
	}

	@Override
	public void save(com.angular.demo.user.model.User user) {
		userRepo.save(user);

	}
}