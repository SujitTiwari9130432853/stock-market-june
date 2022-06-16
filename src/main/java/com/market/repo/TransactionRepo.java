package com.market.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.model.Transactions;

public interface TransactionRepo extends MongoRepository<Transactions, Integer> {

}
