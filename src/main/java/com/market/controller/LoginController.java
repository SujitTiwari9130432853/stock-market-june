package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.Login;
import com.market.service.LoginService;

@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	LoginService loginservice;
	
	@PostMapping("/login")
	public Login saveLoginDetails(@RequestBody Login login){
		Login addLogin=loginservice.saveLoginDetails(login);
		return addLogin;
	}

}
