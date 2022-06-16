package com.market.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.market.model.Transactions;
import com.market.service.TransactionService;

@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:4200")
public class TransactionController {
	@Autowired
	TransactionService transactionservice;
	
	@PostMapping("/transaction/save")
	public Transactions addTrans(@RequestBody Transactions t){
		Transactions add=transactionservice.saveTransaction(t);
		return add;
	}
	
	@GetMapping("/transaction/{id}")
	public Optional<Transactions> getbyID(@PathVariable int id){
		Optional<Transactions> getTrans=transactionservice.getById(id);
		return getTrans;
	}
	
	@GetMapping("/transaction/all")
	public List<Transactions> allTrans(@RequestBody Transactions t1){
		List<Transactions> getAll=transactionservice.getAll(t1);
		return getAll;
	}
	
	@PutMapping("transaction/update")
	public List<Object> updateMarket(@RequestBody Transactions transaction){
		return transactionservice.saveTransactionupdate(transaction);
	}
	
	@DeleteMapping("transaction/{id}")
	public String deleteByID(@PathVariable int id){
		String l = transactionservice.deleteById(id);
		return l;
	}
	
	@DeleteMapping("transaction/deleteAll")
	public String deleteAll(@RequestBody Transactions tr){
		String l = transactionservice.deleteAll();
		return l;
	}

}
