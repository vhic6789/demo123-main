package com.example.demo123.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "userbank")
public class userbank extends base {

	private String username;
	private String namebank;
	private String numbank;
	
	public userbank() {}

	public userbank(String username, String namebank, String numbank) {
		this.username = username;
		this.namebank = namebank;
		this.numbank = numbank;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNamebank() {
		return namebank;
	}

	public void setNamebank(String namebank) {
		this.namebank = namebank;
	}

	public String getNumbank() {
		return numbank;
	}

	public void setNumbank(String numbank) {
		this.numbank = numbank;
	}
	
}
