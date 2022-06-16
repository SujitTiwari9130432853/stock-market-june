package com.market.model;

//import javax.persistence.Entity;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="market")
public class Market {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;	
	String name;
	float value;
	
	public Market() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Market(int id, String name, float value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
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

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Market [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
	
	

}
