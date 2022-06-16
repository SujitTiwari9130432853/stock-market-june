package com.market.model;

//import java.security.Timestamp;

import java.time.LocalDate;
import java.time.LocalTime;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="sharevalue")
public class ShareValue {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	int share_id;
	float current_value;
	LocalDate date=LocalDate.now();
	LocalTime time=LocalTime.now();
	
	
	public ShareValue() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ShareValue(int id, int share_id, float current_value, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.share_id = share_id;
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


	public int getShare_id() {
		return share_id;
	}


	public void setShare_id(int share_id) {
		this.share_id = share_id;
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
		return "ShareValue [id=" + id + ", share_id=" + share_id + ", current_value=" + current_value + ", date=" + date
				+ ", time=" + time + "]";
	}
	
	
	
	

}
