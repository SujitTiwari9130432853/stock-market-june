package com.market.model;

//import javax.persistence.Entity;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="share")
public class Share {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	int totalStocks;
	int stockToSell;
	float stockPrice;
	int marketCap;
	String marketType;
	
	
	public Share() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Share(int id, String name, int totalStocks, int stockToSell, float stockPrice, int marketCap,
			String marketType) {
		super();
		this.id = id;
		this.name = name;
		this.totalStocks = totalStocks;
		this.stockToSell = stockToSell;
		this.stockPrice = stockPrice;
		this.marketCap = marketCap;
		this.marketType = marketType;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getTotalStocks() {
		return totalStocks;
	}


	public void setTotalStocks(int totalStocks) {
		this.totalStocks = totalStocks;
	}


	public int getStockToSell() {
		return stockToSell;
	}


	public void setStockToSell(int stockToSell) {
		this.stockToSell = stockToSell;
	}


	public float getStockPrice() {
		return stockPrice;
	}


	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}


	public int getMarketCap() {
		return marketCap;
	}


	public void setMarketCap(int marketCap) {
		this.marketCap = marketCap;
	}


	public String getMarketType() {
		return marketType;
	}


	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}


	@Override
	public String toString() {
		return "Share [id=" + id + ", name=" + name + ", totalStocks=" + totalStocks + ", stockToSell=" + stockToSell
				+ ", stockPrice=" + stockPrice + ", marketCap=" + marketCap + ", marketType=" + marketType + "]";
	}
	
	

}
