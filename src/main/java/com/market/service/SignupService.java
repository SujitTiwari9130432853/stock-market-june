package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Signup;
import com.market.repo.SignupRepo;

@Service
public class SignupService {
	@Autowired
	SignupRepo signuprepo;
	
	public Signup saveSignUpDetails(Signup s){
		Signup addedSignup = signuprepo.save(s);
		return addedSignup;
	}
}
