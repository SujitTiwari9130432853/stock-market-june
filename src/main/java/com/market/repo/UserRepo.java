package com.market.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.model.User;

public interface UserRepo extends MongoRepository<User, Integer>{

}
