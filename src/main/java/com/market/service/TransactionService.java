package com.market.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Market;
import com.market.model.Transactions;
import com.market.repo.MarketRepo;
import com.market.repo.TransactionRepo;

@Service

public class TransactionService {
	@Autowired
	TransactionRepo transactionrepo;
	@Autowired
	MarketRepo marketrepo;
	
	public Transactions saveTransaction(Transactions t){
		Transactions add=transactionrepo.save(t);
		return add;
	}
	
	public Optional<Transactions> getById(int id){
		Optional<Transactions> getbyid=transactionrepo.findById(id);
		return getbyid;
	}
	
	public List<Transactions> getAll(Transactions tr){
		List<Transactions> all=transactionrepo.findAll();
		return all;
	}
	public List<Object> saveTransactionupdate(Transactions transaction){
		List<Object> list = new ArrayList<Object>();
		Optional<Market> market=marketrepo.findById(transaction.getMarket_id());
		list.add(market.get());
		market.get().setValue(market.get().getValue()+transaction.getCurrent_value());
		list.add(market.get());
		list.add(transaction);
		marketrepo.save(market.get());
		transactionrepo.save(transaction);
		return list;
	}
	
	public String deleteById(int id){
		List<Transactions> l = new ArrayList<>();
		List<Transactions> t = transactionrepo.findAll();
		for (Transactions transactions : t) {
			if (transactions.getId()==id) {
				transactionrepo.deleteById(id);
			} else {
				l.add(transactions);
			}
		}
		return "The element is Deleted";
	}
	
	public String deleteAll(){
		List<Transactions> all = transactionrepo.findAll();
		transactionrepo.deleteAll(all);
		return "ALL ELEMETS DELETED!!! IT'S EMPTY NOW";
	}
	
}
