package com.market.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.model.Share;

public interface ShareRepo extends MongoRepository<Share, Integer>{

	public Share findByName(String s1);
}
