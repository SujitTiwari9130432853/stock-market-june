package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.Signup;
import com.market.service.SignupService;

@RestController
@RequestMapping
public class SignUpController {
   
	@Autowired
	SignupService signupservice;
	
	@PostMapping("/signup")
	public Signup save(Signup s){
		Signup s1 = signupservice.saveSignUpDetails(s);
		return s1;
	}
	
}
