package com.market.model;

import java.time.LocalDate;

import java.time.LocalTime;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="transactions")
public class Transactions {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	int market_id;
	float current_value;
	LocalDate date=LocalDate.now();
	LocalTime time=LocalTime.now();
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(int id, int market_id, float current_value, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.market_id = market_id;
		this.current_value = current_value;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarket_id() {
		return market_id;
	}

	public void setMarket_id(int market_id) {
		this.market_id = market_id;
	}

	public float getCurrent_value() {
		return current_value;
	}

	public void setCurrent_value(float current_value) {
		this.current_value = current_value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", market_id=" + market_id + ", current_value=" + current_value + ", date="
				+ date + ", time=" + time + "]";
	}

	
	
	

}
