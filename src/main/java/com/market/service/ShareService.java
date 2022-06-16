package com.market.service;


import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Share;
import com.market.repo.MarketRepo;
import com.market.repo.ShareRepo;
import com.market.repo.ShareValueRepo;
import com.market.repo.TransactionRepo;

@Service

public class ShareService {
	@Autowired
	ShareRepo sharerepo;

	@Autowired
	TransactionRepo transrepo;

	@Autowired
	MarketRepo marketrepo;

	@Autowired
	ShareValueRepo sharevaluerepo;

	public Share saveShare(Share share) {
		Share updateShare = sharerepo.save(share);
		return updateShare;
	}

	public Optional<Share> getShareById(int id) {
		Optional<Share> share = sharerepo.findById(id);
		return share;
	}

	public List<Share> getAll() {
		List<Share> all = sharerepo.findAll();
		return all;
	}

	public String deleteById(int id) {
		List<Share> s = new ArrayList<>();
		List<Share> l = sharerepo.findAll();
		for (Share share : l) {
			if (share.getId() == id) {
				sharerepo.delete(share);
			} else {
				s.add(share);
			}
		}
		return "The element is deleted";
	}

	public String deleteAll() {
		List<Share> all = sharerepo.findAll();
		sharerepo.deleteAll(all);
		return "ALL ELEMETS DELETED!!! IT'S EMPTY NOW";
	}

	public List<Share> getByName(String name) {
		List<Share> all = sharerepo.findAll().stream().filter(i -> i.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		return all;
	}

	public Optional<Share> getMin() {
		Optional<Share> min = sharerepo.findAll().stream().min(Comparator.comparing(Share::getStockPrice));
		return min;
	}

	public Optional<Share> getMax() {
		Optional<Share> max = sharerepo.findAll().stream().max(Comparator.comparing(Share::getStockPrice));
		return max;
	}

	public List<Share> getSelected(int n) {
		List<Share> select = sharerepo.findAll().stream().filter(i -> i.getStockPrice() > n)
				.collect(Collectors.toList());
		return select;
	}

	public List<Share> getLatestShare(int n) {
		List<Share> result = sharerepo.findAll().stream().filter(i -> i.getId() <= n).collect(Collectors.toList());
		return result;
	}

	public ArrayList<String> getFromName(String s) {
		List<Share> l = sharerepo.findAll();
		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < l.size(); i++) {
			String s1 = l.get(i).getName();
			s1 = s1.toLowerCase();
			if (s1.contains(s)) {
				al.add(s1);
			}

		}
		return al;
	}
	
	public List<Share> getShareFromChar(String s){
		List<Share> sl = getAll();
		List<Share> S = new ArrayList<>();
		List<String> ls = getFromName(s);
		for (int i = 0; i < sl.size(); i++) {
			for (int j = 0; j < ls.size(); j++) {
			if(sl.get(i).getName().toLowerCase().equals(getFromName(s).get(j))){
			String st = sl.get(i).getName();
			List<Share> nls = getByName(st);
			S.addAll(nls);
			}
			}
		}
		return S;
	}
	
	public Share stockAfterSell(int id, int StockToSell){
		List<Share> sl = new ArrayList<>();
		Optional<Share> share = sharerepo.findById(id);
		sl.add(share.get());
		share.get().setStockToSell(share.get().getTotalStocks()-StockToSell);
		sl.add(share.get());
		return sharerepo.save(share.get());
	}
	
	public List<Share> lessThanStock(int n){
		List<Share> l = sharerepo.findAll().stream().filter(i->i.getStockToSell()<n).collect(Collectors.toList());
		return l;
	}
	
	public int remainingStock(int id, int stocktosell){
		List<Share> sl = new ArrayList<>();
		Optional<Share> share = sharerepo.findById(id);
		sl.add(share.get());
		share.get().setStockToSell(share.get().getTotalStocks()-stocktosell);
		sl.add(share.get());
		Share s = sharerepo.save(share.get());
		int s1 = s.getTotalStocks()-s.getStockToSell();
		while(share.get().getId()==id){
			share.get().setTotalStocks(s1);
		}
		sl.add(share.get());
		
		return s1;
		
	}

}
