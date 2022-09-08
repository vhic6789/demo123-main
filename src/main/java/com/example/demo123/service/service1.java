package com.example.demo123.service;

import java.util.List;

import com.example.demo123.dto.GiaodichDTO;
import com.example.demo123.dto.Thongtincanhan;
import com.example.demo123.dto.Thongtingiaodich;
import com.example.demo123.dto.dangkyDTO;
import com.example.demo123.models.comments;
import com.example.demo123.models.transaction;
import com.example.demo123.models.userbank;
import com.example.demo123.models.users;
//import com.example.demo123.repositories.userRps;

public interface service1{
	public List<Thongtingiaodich> getTradeByCreateby(String username);
	public List<Thongtingiaodich> getAllMyTrade(String namesell, String namebuy);
	public Thongtingiaodich getMyTrade(String Username, Long id);
	public List<comments> getAllCommentsByTransactionid(Long id);
	public boolean flagCreateTrade(String namesell, String namebuy);
	public List<Thongtingiaodich> getAllMyTradeNotCreateby(String username);
	public Integer countNotiNowday(String username);
	public String getSdtMomo();
	public Thongtincanhan getDetailUser(String username);
	public List<Thongtingiaodich> getHomePage(int start, int limit);
	//public Page<transaction> getAllTradeByCreatedateDesc(Pageable pageable);
	public List<Thongtingiaodich> getAllMyTradePage(String username, int start, int limit);
	public String createTrade(GiaodichDTO giaodich);
	public String createCmt(comments cmt);
	public String updateTrade(Long id, String status, String username);
	public int trangthaigiaodich(Long id);
	public String register(dangkyDTO dangky);
	public boolean confirm(Long id);
	public List<transaction> getHomePageAdmin(int start, int limit);
	//public List<transaction> findallgdct(String username);
	public boolean updateMomo(String sdt);
	public boolean changePassword(Long id, String newpassword);
	public boolean updatebank(String username, String namebank, String numbank);
	public String getUserbank(String username);
}
