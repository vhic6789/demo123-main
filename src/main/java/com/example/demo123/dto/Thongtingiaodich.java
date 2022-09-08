package com.example.demo123.dto;

import com.example.demo123.models.transaction;

public class Thongtingiaodich {
	private Long id;
	private String Tieude;
	private String Ngaytao;
	private String Magiaodich;
	private String Nguoiban;
	private String Nguoimua;
	private String Nguoitao;
	private int Sophutgiaodich;
	private int Gia;
	private int Phi;
	private int Tongtien;
	private String Trangthaiban;
	private String Trangthaimua;
	private String Trangthaichung;
	private int Sophutconlai;
	private int Status; //0-false 1-true
	
	public Thongtingiaodich() {
		Ngaytao = "";
		Trangthaiban = "";
		Trangthaimua = "";
		Trangthaichung = "";
		Sophutconlai = -1;
		Status = -1;
	}
	
	public Thongtingiaodich(transaction tst) {
		id = tst.getId();
		Tieude = tst.getTitle();
		//Ngaytao = tst.getCreatedate();
		Magiaodich = tst.getCode();
		Nguoiban = tst.getUsersell();
		Nguoimua = tst.getUserbuy();
		Nguoitao = tst.getCreateby();
		Sophutgiaodich = tst.getMinutes();
		Gia = tst.getPrice();
		Phi = tst.getFee();
		Tongtien = tst.getPrice() + tst.getFee();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTieude() {
		return Tieude;
	}

	public void setTieude(String tieude) {
		Tieude = tieude;
	}

	public String getNgaytao() {
		return Ngaytao;
	}

	public void setNgaytao(String ngaytao) {
		Ngaytao = ngaytao;
	}

	public String getMagiaodich() {
		return Magiaodich;
	}

	public void setMagiaodich(String magiaodich) {
		Magiaodich = magiaodich;
	}

	public String getNguoiban() {
		return Nguoiban;
	}

	public void setNguoiban(String nguoiban) {
		Nguoiban = nguoiban;
	}

	public String getNguoimua() {
		return Nguoimua;
	}

	public void setNguoimua(String nguoimua) {
		Nguoimua = nguoimua;
	}

	public String getNguoitao() {
		return Nguoitao;
	}

	public void setNguoitao(String nguoitao) {
		Nguoitao = nguoitao;
	}

	public int getSophutgiaodich() {
		return Sophutgiaodich;
	}

	public void setSophutgiaodich(int sophutgiaodich) {
		Sophutgiaodich = sophutgiaodich;
	}

	public int getGia() {
		return Gia;
	}

	public void setGia(int gia) {
		Gia = gia;
	}

	public int getPhi() {
		return Phi;
	}

	public void setPhi(int phi) {
		Phi = phi;
	}

	public int getTongtien() {
		return Tongtien;
	}

	public void setTongtien(int tongtien) {
		Tongtien = tongtien;
	}

	public String getTrangthaiban() {
		return Trangthaiban;
	}

	public void setTrangthaiban(String trangthaiban) {
		Trangthaiban = trangthaiban;
	}

	public String getTrangthaimua() {
		return Trangthaimua;
	}

	public void setTrangthaimua(String trangthaimua) {
		Trangthaimua = trangthaimua;
	}

	public String getTrangthaichung() {
		return Trangthaichung;
	}

	public void setTrangthaichung(String trangthaichung) {
		Trangthaichung = trangthaichung;
	}

	public int getSophutconlai() {
		return Sophutconlai;
	}

	public void setSophutconlai(int sophutconlai) {
		Sophutconlai = sophutconlai;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}
	
}
