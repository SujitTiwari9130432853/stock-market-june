package com.market.model;

public class Login {
	
	public String Username;
	public String Password;
	

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	@Override
	public String toString() {
		return "Login [Username=" + Username + ", Password=" + Password + "]";
	}

	
}
