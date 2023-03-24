package com.example.demo123.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.bytebuddy.asm.Advice.This;

public class dangkyDTO {
	private String taikhoan;
	private String matkhau;
	private String nhaplaimatkhau;
	private String sodienthoai;
	private String gmail;
	
	public dangkyDTO() {
	
	}

	public dangkyDTO(String taikhoan, String matkhau, String nhaplaimatkhau, String sodienthoai, String gmail) {
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.nhaplaimatkhau = nhaplaimatkhau;
		this.sodienthoai = sodienthoai;
		this.gmail = gmail;
	}

	public String getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getNhaplaimatkhau() {
		return nhaplaimatkhau;
	}

	public void setNhaplaimatkhau(String nhaplaimatkhau) {
		this.nhaplaimatkhau = nhaplaimatkhau;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	public void clear() {
		this.taikhoan = this.taikhoan.trim();
		this.matkhau = this.matkhau.trim();
		this.nhaplaimatkhau = this.nhaplaimatkhau.trim();
		this.sodienthoai = this.sodienthoai.trim();
		this.gmail = this.gmail.trim();
	}
	
	public boolean empty() {
		this.clear();
		if(this.taikhoan.equals("") || this.matkhau.equals("") || this.nhaplaimatkhau.equals("") || this.sodienthoai.equals("") || this.gmail.equals("")) {
			return true;
		}
		return false;
	}
	
	public boolean matkhaunhaplai() {
		if(this.matkhau.equals(this.nhaplaimatkhau)) {
			return true;
		}
		return false;
	}
	
	public boolean kiemtra(String thamso) {
		if(thamso.length() < 5 || thamso.length() > 20)
			return false;
		for(int i=0; i<thamso.length(); i++) {
			if(!(thamso.charAt(i) >= 'a' && thamso.charAt(i) <='z' || thamso.charAt(i) >= '0' && thamso.charAt(i) <= '9'))
				return false;
		}
		return true;
	}
	
	public boolean kiemtraSDT(String thamso) {
		if(thamso.length() != 10 && thamso.length() != 11)
			return false;
		for(int i=0; i<thamso.length(); i++) {
			if(!(thamso.charAt(i) >= '0' && thamso.charAt(i) <= '9'))
				return false;
		}
		return true;
	}
	
	public boolean kiemtraGmail(String thamso) {
		Pattern pattern;
		Matcher matcher;
		String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
		pattern = Pattern.compile(EMAIL_REGEX);
		matcher = pattern.matcher(thamso);
		return matcher.matches();
	}
	
}
