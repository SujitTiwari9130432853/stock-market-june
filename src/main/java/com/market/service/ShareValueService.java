package com.market.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.market.model.ShareValue;
import com.market.repo.ShareValueRepo;

@Service

public class ShareValueService {
	@Autowired
	ShareValueRepo sharevaluerepo;
	
	public ShareValue saveShare(ShareValue sharevalue){
		ShareValue sv=sharevaluerepo.save(sharevalue);
		return sv;
	}
	
	public Optional<ShareValue> getShareValuebyID(int id){
		Optional<ShareValue> getbyid=sharevaluerepo.findById(id);
		return getbyid;
	}
	
	public List<ShareValue> getAll(ShareValue s){
		List<ShareValue> all=sharevaluerepo.findAll();
		return all;
	}
	
	public String deleteById(int id){
		List<ShareValue> l = new ArrayList<ShareValue>();
		List<ShareValue> s = sharevaluerepo.findAll();
		for (ShareValue shareValue : s) {
			if (shareValue.getId()==id) {
				sharevaluerepo.delete(shareValue);
			} else {
				l.add(shareValue);
			}
		}
		return "The element is deleted";
	}
	
	public String deleteAll(){
		List<ShareValue> all = sharevaluerepo.findAll();
		sharevaluerepo.deleteAll(all);
		return "ALL ELEMETS DELETED!!! IT'S EMPTY NOW";
	}
	
	public List<ShareValue> latestData(int n){
		List<ShareValue> all = sharevaluerepo.findAll()
				.stream()
				.sorted(Comparator.comparing(ShareValue::getDate).reversed()).limit(n)
				.collect(Collectors.toList());
		return all;
	}

}
