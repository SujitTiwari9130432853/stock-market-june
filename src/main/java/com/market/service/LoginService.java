package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Login;
import com.market.repo.LoginRepo;

@Service
public class LoginService {
	
	@Autowired
	LoginRepo loginrepo;
	
	public Login saveLoginDetails(Login login){
		Login addLogin=loginrepo.save(login);
		return addLogin;
	}
	
	
}
