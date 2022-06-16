package com.market.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.User;
import com.market.repo.UserRepo;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	UserRepo userrepo;
	
	@PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser){
		List<User> users = userrepo.findAll();
		
		System.out.println("New user : "+newUser.toString());
		
		if (users.equals(newUser)) {
			System.out.println("User Already exists !");
			
			return Status.USER_ALREADY_EXIST;
		}
		
	userrepo.save(newUser);
		 
		return Status.SUCCESS;
	}
	
	
	@PostMapping("/users/login")
	public Status loginUser(@Valid @RequestBody User user){
		List<User> users = userrepo.findAll();
		
		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(true);
				
				userrepo.save(user);
				
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
	
	@PostMapping("/users/logout")
	public Status logUserOut(@Valid @RequestBody User user){
		List<User> users = userrepo.findAll();
		
		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(false);
				
				userrepo.save(user);
				
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
	
	@DeleteMapping("/users/all")
	public Status deleteUsers(){
		userrepo.deleteAll();
		return Status.SUCCESS;
	}
	
}
