package com.angular.demo.config.jwt;

import java.io.Serializable;

public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;

	private String username;
	private String password;
	private String email;

	public JwtRequest(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}