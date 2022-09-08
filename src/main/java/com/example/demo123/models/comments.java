package com.example.demo123.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class comments extends base {

	private Long transactionid;
	private String contents;
	
	public comments() {
		
	}
	
	public comments(Long transactionid, String contents) {
	
		this.transactionid = transactionid;
		this.contents = contents;
	}

	public Long getTransactionid() {
		return transactionid;
	}
	public void setTransactioncode(Long transactionid) {
		this.transactionid = transactionid;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}