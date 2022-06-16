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

import com.market.controller.MarketController;
import com.market.model.Market;
import com.market.repo.MarketRepo;
import com.market.service.MarketService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MarketControllerTest {
	@InjectMocks
	MarketController marketcontroller;
	
	@Mock
	MarketService marketservice;
	
	@Mock
	MarketRepo marketrepo;
	
	@Test
	public void addMarketTest(){
		Market m = new Market();
		m.setId(1);
		m.setName("Nifty");
		m.setValue(54654);
		
		List<Market> ml = new ArrayList<Market>();
		
		ml.add(m);
		for (Market market : ml) {
			Market m1 =marketservice.saveMarket(market);
		
		when(marketcontroller.addMarket(m)).thenReturn(m1);
		assertEquals(1, ml.size());
	}
	}
	
	@Test
	public void getMarketByIdTest(){
		
		List<Market> l = new ArrayList<>();
		Market m = new Market();
		m.setId(1);
		m.setName("Nifty");
		m.setValue(54654);
		l.add(m);
		
		Optional<Market> o = l.stream().findFirst();
		
		when(marketservice.getMarketById(1)).thenReturn(o);
		assertEquals(marketcontroller.getMarket(1), o);
		
	}
	
	@Test
	public void getAllTest(){
		
		Market m = new Market();
		m.setId(1);
		m.setName("nifty");
		m.setValue(65310);
		
		List<Market> l = new ArrayList<>();
		l.add(m);
		
		when(marketservice.getAll()).thenReturn(l);
		assertEquals(1, marketcontroller.allMarket().size());
		
	}
	
	
	@Test
	public void deleteByIdTest(){
		List<Market> l = new ArrayList<>();
		
		Market m = new Market();
		m.setId(1);
		m.setName("nifty");
		m.setValue(51515);
		
		l.add(m);
		
		Optional<Market> o = l.stream().findFirst();
		
		when(marketservice.deleteById(1)).thenReturn(null);
		assertEquals(marketcontroller.deleteById(1),null);
	}
	
	
	@Test
	public void deleteAllMarketTest(){
		
		Market m = new Market();
		m.setId(1);
		m.setName("sensex");
		m.setValue(51123);
		
		Market m1 = new Market();
		m1.setId(2);
		m1.setName("nifty");
		m1.setValue(45665);
		
		List<Market> l = new ArrayList<>();
		l.add(m1);
		l.add(m);
		marketservice.saveMarket(m);
		marketservice.saveMarket(m1);
		marketservice.deleteAll();
		when(marketcontroller.deleteAll(m)).thenReturn(null);
		when(marketservice.deleteAll()).thenReturn(null);
		assertEquals(2, l.size());
		
	}
	

}
