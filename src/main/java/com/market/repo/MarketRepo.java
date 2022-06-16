package com.market.repo;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.model.Market;

public interface MarketRepo extends MongoRepository<Market, Integer>{

}
