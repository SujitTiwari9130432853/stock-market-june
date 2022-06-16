package com.market.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.model.Login;

public interface LoginRepo extends MongoRepository<Login, Integer> {

}
