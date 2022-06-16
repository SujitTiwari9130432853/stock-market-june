package com.market.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.model.ShareValue;

public interface ShareValueRepo extends MongoRepository<ShareValue, Integer>{

}
