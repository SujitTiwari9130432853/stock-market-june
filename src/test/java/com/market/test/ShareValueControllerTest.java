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

import com.market.controller.ShareValueController;
import com.market.model.ShareValue;
import com.market.repo.ShareValueRepo;
import com.market.service.ShareValueService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ShareValueControllerTest {
	@InjectMocks
	ShareValueController sharevaluecontroller;
	
	@Mock
	ShareValueService sharevalueservice;
	
	@Mock
	ShareValueRepo sharevaluerepo;
	
	@Test
	public void addedSahreValueTest(){
		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(2);
		sv.setCurrent_value(2530);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());
		
		List<ShareValue> l = new ArrayList<ShareValue>();
		l.add(sv);
		
		for (ShareValue shareValue : l) {
			ShareValue s = sharevalueservice.saveShare(shareValue);
			when(sharevaluecontroller.addShareValue(sv)).thenReturn(s);
			assertEquals(1, l.size());
		}
		
	}
	
	@Test
	public void getShareValueByIdTest(){
		List<ShareValue> l = new ArrayList<>();
		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(2);
		sv.setCurrent_value(2530);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());
		
		l.add(sv);
		
		Optional<ShareValue> o = l.stream().findFirst();
		
		when(sharevalueservice.getShareValuebyID(1)).thenReturn(o);
		assertEquals(sharevaluecontroller.getById(1), o);
	}
	
	@Test
	public void getAllTest(){
		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(2);
		sv.setCurrent_value(2530);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());
		
		List<ShareValue> l = new ArrayList<>();
		l.add(sv);
		
		when(sharevalueservice.getAll(sv)).thenReturn(l);
		assertEquals(1, sharevaluecontroller.getAll(sv).size());
	}
	
	@Test
	public void deleteByIdTest(){
		
		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(2);
		sv.setCurrent_value(2530);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());
		
		when(sharevalueservice.deleteById(1)).thenReturn(null);
		assertEquals(sharevaluecontroller.deleteById(1), null);
	}
	
	@Test
	public void deleteAllTest(){
		
		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(2);
		sv.setCurrent_value(2530);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());
		
		List<ShareValue> l = new ArrayList<>();
		l.add(sv);
		
		sharevalueservice.saveShare(sv);
		sharevalueservice.deleteAll();
		
		when(sharevaluecontroller.deleteAll(sv)).thenReturn(null);
		assertEquals(1, l.size());
	}

}
