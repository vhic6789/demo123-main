package com.example.demo123.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class persistentlogins {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String username;
	private String series;
	private String token;
	private Date lastused;
	
	public persistentlogins() {
	
	}

	public persistentlogins(Long id, String username, String series, String token, Date lastused) {
		super();
		this.id = id;
		this.username = username;
		this.series = series;
		this.token = token;
		this.lastused = lastused;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastused() {
		return lastused;
	}

	public void setLastused(Date lastused) {
		this.lastused = lastused;
	}
	
	
}
