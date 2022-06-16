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

import com.market.model.Transactions;
import com.market.repo.TransactionRepo;
import com.market.service.TransactionService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {
	@InjectMocks
	TransactionService transactionservice;
	
	@Mock
	TransactionRepo transactionrepo;
	
	@Test
	public void findAllTest(){
		List<Transactions> l = new ArrayList<Transactions>();
		Transactions tr = new Transactions();
		tr.setId(1);
		tr.setMarket_id(2);
		tr.setCurrent_value(46165);
		tr.setDate(tr.getDate());
		tr.setTime(tr.getTime());
		
		l.add(tr);
		
		when(transactionrepo.findAll()).thenReturn(l);
		assertEquals(1, transactionservice.getAll(tr).size());
		
	}
	
	@Test
	public void getByIdTest(){
		List<Transactions> list=new ArrayList<>();
		Transactions tr = new Transactions();
		tr.setId(1);
		tr.setMarket_id(2);
		tr.setCurrent_value(46165);
		tr.setDate(tr.getDate());
		tr.setTime(tr.getTime());
		
		list.add(tr);
		
		Optional<Transactions> op = list.stream().findFirst();
		
		when(transactionrepo.findById(tr.getId())).thenReturn(op);
		assertEquals(transactionservice.getById(1), op);
	}
	
	@Test
	public void saveTransactionTest(){
		List<Transactions> l = new ArrayList<>();
		Transactions tr = new Transactions();
		tr.setId(1);
		tr.setMarket_id(2);
		tr.setCurrent_value(46165);
		tr.setDate(tr.getDate());
		tr.setTime(tr.getTime());
		
		l.add(tr);
		
		for (Transactions transactions : l) {
			when(transactionrepo.save(transactions)).thenReturn(tr);
			assertEquals(transactionservice.saveTransaction(tr), l.get(0));
		}
	}
	
//	@Test
//	public void deleteTransactionById(){
//		List<Transactions> l = new ArrayList<>();
//		Transactions tr = new Transactions();
//		tr.setId(1);
//		tr.setMarket_id(2);
//		tr.setCurrent_value(46165);
//		tr.setDate(tr.getDate());
//		tr.setTime(tr.getTime());
//		
//		l.add(tr);
//		int id=tr.getId();
//		
//		List<Transactions> tl = transactionrepo.findAll();
//		for (Transactions transactions : tl) {
//			if(transactions.getId()==id){
//				transactionrepo.delete(transactions);
//			}
//			when(transactionservice.deleteById(id)).thenReturn(l.toString());
//			assertEquals(transactionservice.deleteById(id), null);
//		}
//	}

}
