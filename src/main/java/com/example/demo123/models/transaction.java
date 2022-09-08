package com.example.demo123.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class transaction extends base {

	private String code;
	private String usersell;
	private String userbuy;
	private Long createid;
	private int price;
	private int fee;
	private int minutes;
	private String title;
	private int statussell; //1-xac nhan giao dich, 0-dang giao dich, -2-huy giao dich, -3-khieu lai
	private int statusbuy; //2-da chuyen tien, 1-xac nhan giao dich, 0-chua chuyen tien, -1-chuyen tien sai, -2-huy giao dich, -3-khieu lai
	private int status;
	
	public transaction() {
		
	}
	
	public transaction(String code, String usersell, String userbuy, Long createid, int price, int fee, int minutes,
			String title, int statussell, int statusbuy, int status) {
	
		this.code = code;
		this.usersell = usersell;
		this.userbuy = userbuy;
		this.createid = createid;
		this.price = price;
		this.fee = fee;
		this.minutes = minutes;
		this.title = title;
		this.statussell = statussell;
		this.statusbuy = statusbuy;
		this.status = status;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsersell() {
		return usersell;
	}
	public void setUsersell(String usersell) {
		this.usersell = usersell;
	}
	public String getUserbuy() {
		return userbuy;
	}
	public void setUserbuy(String userbuy) {
		this.userbuy = userbuy;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getStatussell() {
		return statussell;
	}
	public void setStatussell(int statussell) {
		this.statussell = statussell;
	}
	public int getStatusbuy() {
		return statusbuy;
	}
	public void setStatusbuy(int statusbuy) {
		this.statusbuy = statusbuy;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCreateid() {
		return createid;
	}
	public void setCreateid(Long createid) {
		this.createid = createid;
	}
	
	
}
