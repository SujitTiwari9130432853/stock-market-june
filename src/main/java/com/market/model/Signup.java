package com.market.model;

public class Signup {

	public String Username;
	public String password;
	
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Signup(String username, String password) {
		super();
		Username = username;
		this.password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Signup [Username=" + Username + ", password=" + password + "]";
	}
	
	
}
