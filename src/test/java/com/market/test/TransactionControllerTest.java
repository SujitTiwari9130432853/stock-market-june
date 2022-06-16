package com.market.test;


import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.market.controller.TransactionController;
import com.market.model.Transactions;
import com.market.repo.TransactionRepo;
import com.market.service.TransactionService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {
	
	@InjectMocks
	TransactionController transactioncontroller;
	
	@Mock
	TransactionService transactionservice;
	
	@Mock
	TransactionRepo transactionrepo;
	
	@Test
	public void addTransactionTest(){
		Transactions tr = new Transactions();
		tr.setId(1);
		tr.setMarket_id(2);
		tr.setCurrent_value(465535);
		tr.setDate(tr.getDate());
		tr.setTime(tr.getTime());
		
		List<Transactions> l = new ArrayList<Transactions>();
		l.add(tr);
		
		for (Transactions transactions : l) {
			Transactions t = transactionservice.saveTransaction(transactions);
			
			when(transactioncontroller.addTrans(tr)).thenReturn(t);
			assertEquals(1, l.size());
		}
	}
	
	@Test
	public void getTransactionByIdTest(){
		List<Transactions> l = new ArrayList<>();
		Transactions tr = new Transactions();
		tr.setId(1);
		tr.setMarket_id(2);
		tr.setCurrent_value(465535);
		tr.setDate(tr.getDate());
		tr.setTime(tr.getTime());
		
		l.add(tr);
		
		Optional<Transactions> o = l.stream().findFirst();
		
		when(transactionservice.getById(1)).thenReturn(o);
		assertEquals(transactioncontroller.getbyID(1), o);
	}
	
	@Test
	public void getAllTest(){
		Transactions tr = new Transactions();
		tr.setId(1);
		tr.setMarket_id(2);
		tr.setCurrent_value(465535);
		tr.setDate(tr.getDate());
		tr.setTime(tr.getTime());
		
		List<Transactions> l = new ArrayList<>();
		l.add(tr);
		
		when(transactionservice.getAll(tr)).thenReturn(l);
		assertEquals(1, transactioncontroller.allTrans(tr).size());
	}
	
	@Test
	public void deleteByIdTest(){
		
		Transactions tr = new Transactions();
		tr.setId(1);
		tr.setMarket_id(2);
		tr.setCurrent_value(465535);
		tr.setDate(tr.getDate());
		tr.setTime(tr.getTime());
		
		when(transactionservice.deleteById(1)).thenReturn(null);
		assertEquals(transactioncontroller.deleteByID(1), null);
	}
	
	@Test
	public void deleteAllTest(){
		
		Transactions tr = new Transactions();
		tr.setId(1);
		tr.setMarket_id(2);
		tr.setCurrent_value(465535);
		tr.setDate(tr.getDate());
		tr.setTime(tr.getTime());
		
		List<Transactions> l = new ArrayList<>();
		l.add(tr);
		
		transactionservice.saveTransaction(tr);
		transactionservice.deleteAll();
		
		when(transactioncontroller.deleteAll(tr)).thenReturn(null);
		assertEquals(1, l.size());
	}
	

}
