package com.qa.entities;

public class SentAudit {

	private String username;
	private String pokename;
	
	public SentAudit() {
		super();
	}
	
	public SentAudit(Audit audit) {
		super();
		this.username = audit.getUsername();
		this.pokename = audit.getPokename();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPokename() {
		return pokename;
	}
	public void setPokename(String pokename) {
		this.pokename = pokename;
	}
	
}
