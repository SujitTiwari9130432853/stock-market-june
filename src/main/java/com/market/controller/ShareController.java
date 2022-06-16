package com.market.controller;

import java.util.ArrayList;
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


import com.market.model.Share;
import com.market.service.ShareService;

@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:4200")
public class ShareController {
	@Autowired
	ShareService shareservice;
	@PostMapping("/share/save")
	public Share addShare(@RequestBody Share share){
		Share addedshare=shareservice.saveShare(share);
		return addedshare;
	}
	
	@GetMapping("/share/{id}")
	public Optional<Share> getShare(@PathVariable int id){
		Optional<Share> getShare=shareservice.getShareById(id);
		return getShare;
	}
	
	@GetMapping("/share/all")
	public List<Share> allShare(){
		List<Share> allshare=shareservice.getAll();
		return allshare;
	}
	
	@DeleteMapping("/share/{id}")
	public String deleteById(@PathVariable int id){
		String l = shareservice.deleteById(id);
		return l;
	}
	
	@DeleteMapping("/share/deleteAll")
	public String deleteAll(@RequestBody Share share1){
		String l = shareservice.deleteAll();
		return l;
 	}
	
	@GetMapping("s/{name}")
	public List<Share> getByName(@PathVariable String name){
		List<Share> l = shareservice.getByName(name);
		return l;
	}
	
	@GetMapping("share/min")
	public Optional<Share> getMin(){
		Optional<Share> m=shareservice.getMin();
		return m;
	}
	
	@GetMapping("share/max")
	public Optional<Share> getMax(){
		Optional<Share> m=shareservice.getMax();
		return m;
	}
	
	@GetMapping("shares/{n}")
	public List<Share> getByValue(@PathVariable int n){
		List<Share> c = shareservice.getSelected(n);
		return c;
	}
	
	@GetMapping("sharesbychoice/{n}")
	public List<Share> getByChoice(@PathVariable int n){
		List<Share> get=shareservice.getLatestShare(n);
		return get;
	}
	
	@GetMapping("sharename/{name}")
	public List<String> getName(@PathVariable String name){
		List<String> gn = shareservice.getFromName(name);
		return gn;
	}
	
	@GetMapping("gsbn/{s}")
	public List<Share> gSbN(@PathVariable String s){
		List<Share> gsb = shareservice.getShareFromChar(s);
		return gsb;
	}
	
	@GetMapping("shareafterstocksell/{id}/{sts}")
	public Share sts(@PathVariable int id, @PathVariable int sts){
		Share s = shareservice.stockAfterSell(id,sts);
		return s;
	}
	
	@GetMapping("lessthan/{n}")
	public List<Share> lessThan(@PathVariable int n){
		List<Share> sl = shareservice.lessThanStock(n);
		return sl;
	}
	
	@GetMapping("remaining/{id}/{sts}")
	public int remainingStock(@PathVariable int id, @PathVariable int sts){
		int sl = shareservice.remainingStock(id, sts);
		return sl;
	}
 	
}
