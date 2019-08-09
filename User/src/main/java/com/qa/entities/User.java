package com.qa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;
	@Column(length=30)
	private String name;
	@Column(length=30)
	private int aId;
	
	public User() {
		super();
	}
	
	public User(Integer uId, String name, int aId) {
		super();
		this.uId = uId;
		this.name = name;
		this.aId = aId;
	}
	
	public Integer getuId() {
		return uId;
	}
	
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getaId() {
		return aId;
	}
	
	public void setaId(int aId) {
		this.aId = aId;
	}
	
	@Override
	public String toString() {
		return "User [uId=" + uId + ", name=" + name + ", aId=" + aId + "]";
	}
	
}
