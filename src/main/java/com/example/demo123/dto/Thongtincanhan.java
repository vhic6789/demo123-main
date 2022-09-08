package com.example.demo123.dto;

import com.example.demo123.models.users;

public class Thongtincanhan {
	
	private Long id;
	private String Username;
	private String Sodienthoai;
	private String Email;
	private String Ngaythamgia;
	private int Giaodichdathamgia;
	private int Giaodichthanhcong;
	private int Diemgiaodich;
	
	public Thongtincanhan() {
	
	}
	
	public Thongtincanhan(users user) {
		this.id = user.getId();
		this.Username = user.getUsername();
		this.Sodienthoai = user.getPhonenumber();
		this.Email = user.getEmail();
		this.Diemgiaodich = user.getPoint();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getSodienthoai() {
		return Sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		Sodienthoai = sodienthoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNgaythamgia() {
		return Ngaythamgia;
	}

	public void setNgaythamgia(String ngaythamgia) {
		Ngaythamgia = ngaythamgia;
	}

	public int getGiaodichdathamgia() {
		return Giaodichdathamgia;
	}

	public void setGiaodichdathamgia(int giaodichdathamgia) {
		Giaodichdathamgia = giaodichdathamgia;
	}

	public int getGiaodichthanhcong() {
		return Giaodichthanhcong;
	}

	public void setGiaodichthanhcong(int giaodichthanhcong) {
		Giaodichthanhcong = giaodichthanhcong;
	}

	public int getDiemgiaodich() {
		return Diemgiaodich;
	}

	public void setDiemgiaodich(int diemgiaodich) {
		Diemgiaodich = diemgiaodich;
	}
	
	
}
