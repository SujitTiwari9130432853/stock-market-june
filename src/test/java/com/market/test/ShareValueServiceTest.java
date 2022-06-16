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

import com.market.model.ShareValue;
import com.market.repo.ShareValueRepo;
import com.market.service.ShareValueService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ShareValueServiceTest {

	@InjectMocks
	ShareValueService sharevalueservice;

	@Mock
	ShareValueRepo sharevaluerepo;

	@Test
	public void findAllTest() {
		List<ShareValue> l = new ArrayList<ShareValue>();

		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(2);
		sv.setCurrent_value(15635);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());

		l.add(sv);

		when(sharevaluerepo.findAll()).thenReturn(l);
		assertEquals(1, sharevalueservice.getAll(sv).size());
	}
	
	@Test
	public void getByIdTest(){
		List<ShareValue> l = new ArrayList<>();
		ShareValue sv = new ShareValue();
		sv.setCurrent_value(5515);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());
		sv.setId(1);
		sv.setShare_id(2);
		
		l.add(sv);
		
		Optional<ShareValue> o = l.stream().findFirst();
		when(sharevaluerepo.findById(1)).thenReturn(o);
		assertEquals(sharevalueservice.getShareValuebyID(1), o);
	}
	
	@Test
	public void saveTest(){
		List<ShareValue> l = new ArrayList<>();
		
		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(1);
		sv.setCurrent_value(511515);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());
		
		l.add(sv);
		
		for (ShareValue shareValue : l) {
			when(sharevaluerepo.save(shareValue)).thenReturn(sv);
			assertEquals(sharevalueservice.saveShare(sv), l.get(0));
		}
	}
	
//	@Test
//	public void deleteShareValueByIdTest(){
//		List<ShareValue> l = new ArrayList<>();
//		ShareValue sv = new ShareValue();
//		sv.setId(1);
//		sv.setShare_id(1);
//		sv.setCurrent_value(511515);
//		sv.setDate(sv.getDate());
//		sv.setTime(sv.getTime());
//		
//		l.add(sv);
//		int id=sv.getId();
//		List<ShareValue> sl = sharevaluerepo.findAll();
//		for (ShareValue shareValue : sl) {
//			if (shareValue.getId()==id) {
//				sharevaluerepo.delete(shareValue);
//			}
//			
//			when(sharevalueservice.deleteById(id)).thenReturn(l.toString());
//			assertEquals(sharevalueservice.deleteById(id), null);
//		}
// 	}

}
