package com.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.ShareValue;
import com.market.service.ShareValueService;

@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:4200")
public class ShareValueController {
	@Autowired
	ShareValueService sharevalueservice;
	
	@PostMapping("/sharevalue/save")
	public ShareValue addShareValue(@RequestBody ShareValue sharevalue){
		ShareValue add=sharevalueservice.saveShare(sharevalue);
		return add;
	}
	
	@GetMapping("/sharevalue/{id}")
	public Optional<ShareValue> getById(@PathVariable int id){
		Optional<ShareValue> getbyid=sharevalueservice.getShareValuebyID(id);
		return getbyid;
	}
	
	@GetMapping("/sharevalue/all")
	public List<ShareValue> getAll(@RequestBody ShareValue s){
		List<ShareValue> getall=sharevalueservice.getAll(s);
		return getall;
	}
	
	@DeleteMapping("/sharevalue/{id}")
	public String deleteById(@PathVariable int id){
		String l = sharevalueservice.deleteById(id);
		return l;
	}
	
	@DeleteMapping("/sharevalue/deleteAll")
	public String deleteAll(@RequestBody ShareValue sv){
		String l = sharevalueservice.deleteAll();
		return l;
	}
	
	@GetMapping("/sv/{n}")
	public List<ShareValue> all(@PathVariable int n){
		List<ShareValue> l = sharevalueservice.latestData(n);
		return l;
	}
	

}
