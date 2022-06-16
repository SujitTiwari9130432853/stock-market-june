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

import com.market.model.Market;
import com.market.repo.MarketRepo;
import com.market.service.MarketService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MarketServiceTest {
	
	@InjectMocks
	MarketService marketservice;
	
	@Mock
	MarketRepo marketrepo;
	
	@Test
	public void findAllMarketTest(){
		List<Market> l = new ArrayList<Market>();
		
		Market m = new Market();
		m.setId(1);
		m.setName("Nifty");
		m.setValue(17863);
		l.add(m);
		
		
		when(marketrepo.findAll()).thenReturn(l);
		assertEquals(1, marketservice.getAll().size());
	}
	
	
	
	@Test
	public void getMarketByIdTest(){
		List<Market> l = new ArrayList<>();
		Market m = new Market();
		m.setId(1);
		m.setName("ABC");
		m.setValue(53131);
		l.add(m);
		Optional<Market> optional = l.stream().findFirst();
		
		
		
		when(marketrepo.findById(1)).thenReturn(optional);
		assertEquals(marketservice.getMarketById(1),optional );
	}
	
	
	
	@Test
	public void saveMarketTest(){
		List<Market> l = new ArrayList<>();
		Market m = new Market();
		m.setId(1);
		m.setName("DEMO");
		m.setValue(5252);
		l.add(m);
		marketservice.saveMarket(m);
		for (Market market : l) 
			
			
			when(marketrepo.save(market)).thenReturn(m);
			assertEquals(marketservice.saveMarket(m), l.get(0));
	}
	
}
