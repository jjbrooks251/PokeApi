package com.qa.entities;

public class SentUser {

	private String name;
	private int aId;
	
	public SentUser() {
		super();
	}
	
	public SentUser(String name, int aId) {
		super();
		this.name = name;
		this.aId = aId;
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
}
