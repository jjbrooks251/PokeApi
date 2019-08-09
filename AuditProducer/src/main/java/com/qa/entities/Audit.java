package com.qa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30)
	private String username;
	@Column(length = 30)
	private String pokename;
	
	public Audit() {
		super();
	}
	
	public Audit(Integer id, String username, String pokename) {
		super();
		this.id = id;
		this.username = username;
		this.pokename = pokename;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Audit [id=" + id + ", username=" + username + ", pokename=" + pokename + "]";
	}
}
