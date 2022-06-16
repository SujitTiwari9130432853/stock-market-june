package com.market.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.model.Signup;

public interface SignupRepo extends MongoRepository<Signup, Integer>{

}
