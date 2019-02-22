package com.epam.course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyProduct {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long prodId;
	private String name;
	private String desc;
	
	public MyProduct() {		
	}
	
	public MyProduct(long prodId, String name, String desc) {
		super();
		this.prodId = prodId;
		this.name = name;
		this.desc = desc;
	}
	
	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
