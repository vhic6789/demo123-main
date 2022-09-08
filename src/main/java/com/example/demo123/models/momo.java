package com.example.demo123.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "momo")
public class momo extends base {

	private String account;
	private int status;
	
	
	public momo() {
		
	}
	
	public momo(String account, int status) {
	
		this.account = account;
		this.status = status;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
