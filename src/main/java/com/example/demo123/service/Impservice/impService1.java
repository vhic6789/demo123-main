package com.example.demo123.service.Impservice;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo123.dto.GiaodichDTO;
import com.example.demo123.dto.Thongtincanhan;
import com.example.demo123.dto.Thongtingiaodich;
import com.example.demo123.dto.dangkyDTO;
import com.example.demo123.models.comments;
import com.example.demo123.models.momo;
import com.example.demo123.models.role;
import com.example.demo123.models.transaction;
import com.example.demo123.models.userbank;
import com.example.demo123.models.users;
import com.example.demo123.repositories.commentsRps;
import com.example.demo123.repositories.momoRps;
import com.example.demo123.repositories.roleRps;
import com.example.demo123.repositories.transactionRps;
import com.example.demo123.repositories.userRps;
import com.example.demo123.repositories.userbankRps;
import com.example.demo123.service.service1;

@Service
public class impService1 implements service1 {

	@Autowired
	private transactionRps Rtransaction;
	@Autowired
	private commentsRps Rcomments;
	@Autowired
	private momoRps Rmomo;
	@Autowired
	private userRps Ruser;
	@Autowired
	private roleRps Rrole;
	@Autowired
	private userbankRps Ruserbank;

	public impService1(transactionRps rtransaction, commentsRps rcomments, momoRps rmomo, userRps ruser, roleRps rrole,
			userbankRps ruserbank) {
		this.Rtransaction = rtransaction;
		this.Rcomments = rcomments;
		this.Rmomo = rmomo;
		this.Ruser = ruser;
		this.Rrole = rrole;
		this.Ruserbank = ruserbank;
	}

	public Thongtingiaodich transactionToThongtingiaodich(String Username, transaction tst) {
		Thongtingiaodich thongtingiaodich;
		thongtingiaodich = new Thongtingiaodich(tst);

		String ngaytao = tst.getCreatedate().getHours() + "h:" + tst.getCreatedate().getMinutes() + " phút | "
				+ tst.getCreatedate().getDate() + "/" + (tst.getCreatedate().getMonth() + 1) + "/"
				+ (tst.getCreatedate().getYear() + 1900);
		thongtingiaodich.setNgaytao(ngaytao);

		if (Username.equals(thongtingiaodich.getNguoiban()) || Username.equals(thongtingiaodich.getNguoimua()))
			thongtingiaodich.setStatus(1);
		else
			thongtingiaodich.setStatus(0);

		String trangthaiban = "";
		if (tst.getStatussell() == 1)
			trangthaiban = "hoàn thành";
		else if (tst.getStatussell() == -2)
			trangthaiban = "hủy giao dịch";
		else if (tst.getStatussell() == -3)
			trangthaiban = "khiếu nại";
		else if (tst.getStatussell() == 0)
			trangthaiban = "đang giao dịch";

		String trangthaimua = "";
		if (tst.getStatusbuy() == 1 || tst.getStatusbuy() == 2)
			trangthaimua = "đã chuyển tiền";
		else if (tst.getStatusbuy() == -1)
			trangthaimua = "chuyển tiền sai";
		else if (tst.getStatusbuy() == -2)
			trangthaimua = "hủy giao dịch";
		else if (tst.getStatusbuy() == -3)
			trangthaimua = "khiếu nại";
		else if (tst.getStatusbuy() == 0)
			trangthaimua = "chưa chuyển tiền";

		LocalDate datenow = LocalDate.now();
		LocalTime timenow = LocalTime.now();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String Sdate = datenow.toString() + " " + timenow.toString();
		Date datetimenow = new Date();

		try {
			datetimenow = formatter.parse(Sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long diff = datetimenow.getTime() - tst.getCreatedate().getTime();
		long diffMinutes = diff / (60 * 1000);
		int thoigianconlai = tst.getMinutes() - (int) diffMinutes;

		String trangthaichung = "đang giao dịch";
		if (tst.getStatussell() == 1 && tst.getStatusbuy() == 1)
			trangthaichung = "hoàn thành";
		else if (tst.getStatussell() == -3 || tst.getStatusbuy() == -3)
			trangthaichung = "khiếu nại";
		else if (thoigianconlai < 1 || tst.getStatusbuy() == -2 || tst.getStatussell() == -2)
			trangthaichung = "đóng cửa";

		thongtingiaodich.setTrangthaiban(trangthaiban);
		thongtingiaodich.setTrangthaimua(trangthaimua);
		thongtingiaodich.setTrangthaichung(trangthaichung);
		thongtingiaodich.setSophutconlai(thoigianconlai);

		return thongtingiaodich;
	}

	@Override
	public List<Thongtingiaodich> getTradeByCreateby(String username) {
		// TODO Auto-generated method stub
		List<Thongtingiaodich> listTTGD = new ArrayList<>();
		Thongtingiaodich thongtingiaodich;
		List<transaction> list = Rtransaction.getByCreateby(username);
		for (transaction o : list) {
			thongtingiaodich = transactionToThongtingiaodich(username, o);
			listTTGD.add(thongtingiaodich);
		}
		return listTTGD;
	}

	@Override
	public List<Thongtingiaodich> getAllMyTrade(String namesell, String namebuy) {
		// TODO Auto-generated method stub
		List<Thongtingiaodich> listTTGD = new ArrayList<>();
		try {
			Thongtingiaodich thongtingiaodich;
			List<transaction> list = Rtransaction.getByUsersellOrUserbuy(namesell, namebuy);
			for (transaction o : list) {
				thongtingiaodich = transactionToThongtingiaodich(namesell, o);
				listTTGD.add(thongtingiaodich);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return listTTGD;
	}

	@Override
	public Thongtingiaodich getMyTrade(String Username, Long id) {
		// TODO Auto-generated method stub
		Thongtingiaodich thongtingiaodich;
		transaction tst;
		try {
			tst = Rtransaction.getById(id);
			thongtingiaodich = transactionToThongtingiaodich(Username, tst);
		} catch (Exception e) {
			// TODO: handle exception
			tst = new transaction();
			thongtingiaodich = new Thongtingiaodich();
		}

		return thongtingiaodich;
	}

	@Override
	public List<comments> getAllCommentsByTransactionid(Long id) {
		// TODO Auto-generated method stub
		return Rcomments.getByTransactionid(id);
	}

	@Override
	public boolean flagCreateTrade(String namesell, String namebuy) {
		// TODO Auto-generated method stub
		LocalDate datenow = LocalDate.now();
		String username = namesell;
		String Snow = datenow.toString();
		int flagAllTop = Rtransaction.countAllTopNow(Snow, namesell, namebuy);
		int flagMyTop = Rtransaction.countMyTopNow(Snow, username);
		// System.out.println(flagAllTop + " | " + flagMyTop);
		if (flagAllTop < 11 && flagMyTop < 6)
			return true;
		return false;
	}

	@Override
	public List<Thongtingiaodich> getAllMyTradeNotCreateby(String username) {
		// TODO Auto-generated method stub
		List<Thongtingiaodich> listTTGD = new ArrayList<>();
		Thongtingiaodich thongtingiaodich;
		String namesell = username;
		String namebuy = username;
		List<transaction> list = Rtransaction.getAllTradeAndNotCreateby(username, namesell, namebuy);
		for (transaction o : list) {
			thongtingiaodich = transactionToThongtingiaodich(username, o);
			listTTGD.add(thongtingiaodich);
		}
		return listTTGD;
	}

	@Override
	public Integer countNotiNowday(String username) {
		// TODO Auto-generated method stub
		LocalDate datenow = LocalDate.now();
		String namesell = username;
		String namebuy = username;
		String Snow = datenow.toString();
		int notifi = Rtransaction.countNotificationNowday(Snow, username, namesell, namebuy);
		return notifi;
	}

	@Override
	public String getSdtMomo() {
		// TODO Auto-generated method stub
		List<momo> list = Rmomo.findAll();
		String sdt = "";
		for (momo o : list)
			if (o.getStatus() == 1)
				sdt = o.getAccount();
		return sdt;
	}

	@Override
	public Thongtincanhan getDetailUser(String username) {
		// TODO Auto-generated method stub
		Thongtincanhan ttcn;
		users user;
		try {
			user = Ruser.findByUsernameLike(username);
			ttcn = new Thongtincanhan(user);
			String ngaythamgia = user.getCreatedate().getDate() + "/" + (user.getCreatedate().getMonth() + 1) + "/"
					+ (user.getCreatedate().getYear() + 1900);
			ttcn.setNgaythamgia(ngaythamgia);

			String namesell = user.getUsername();
			String namebuy = user.getUsername();
			int giaodichthanhcong = Rtransaction.countMyTradeTrue(namesell, namebuy);
			ttcn.setGiaodichthanhcong(giaodichthanhcong);

			int giaodichthamgia = Rtransaction.countByUsersellOrUserbuy(namesell, namebuy);
			ttcn.setGiaodichdathamgia(giaodichthamgia);
		} catch (Exception e) {
			// TODO: handle exception
			ttcn = new Thongtincanhan();
		}

		return ttcn;
	}

	@Override
	public List<Thongtingiaodich> getHomePage(int start, int limit) {
		// TODO Auto-generated method stub
		List<Thongtingiaodich> listTTGD = new ArrayList<>();
		Thongtingiaodich thongtingiaodich;
		Pageable pageable = PageRequest.of(start, limit);
		List<transaction> pagettgd = Rtransaction.findAllByOrderByCreatedateDesc(pageable).getContent();
		for (transaction o : pagettgd) {
			thongtingiaodich = transactionToThongtingiaodich("", o);
			listTTGD.add(thongtingiaodich);
		}
		return listTTGD;
	}

	@Override
	public List<Thongtingiaodich> getAllMyTradePage(String username, int start, int limit) {
		// TODO Auto-generated method stub
		List<Thongtingiaodich> listTTGD = new ArrayList<>();
		Thongtingiaodich thongtingiaodich;
		Pageable pageable = PageRequest.of(start, limit);
		List<transaction> pagettgd = Rtransaction.findAllByUsersellOrUserbuyOrderByCreatedateDesc(username, username,
				pageable);
		for (transaction o : pagettgd) {
			thongtingiaodich = transactionToThongtingiaodich("", o);
			listTTGD.add(thongtingiaodich);
		}
		return listTTGD;
	}

	String randomString(int len) {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	boolean checkXss(String str) {
		if (str.indexOf('<') != -1 || str.indexOf('>') != -1)
			return true;
		return false;
	}

	@Override
	public String createTrade(GiaodichDTO giaodich) {
		// TODO Auto-generated method stub
		String message = "success";
		try {
			if (!giaodich.empty() && !checkXss(giaodich.getTieude())) {
				String usersell = giaodich.getNguoiban();
				String userbuy = giaodich.getNguoimua();
				int minutes = (Integer.parseInt(giaodich.getHour()) * 60) + Integer.parseInt(giaodich.getMinutes());
				String title = giaodich.getTieude();
				int price = Integer.parseInt(giaodich.getGiatri());

				if (Ruser.countByUsername(usersell) > 0 && Ruser.countByUsername(userbuy) > 0 && minutes > 14
						&& title.length() <= 50 && price > 0 && !usersell.equals(userbuy)) {
					if (this.flagCreateTrade(usersell, usersell) && this.flagCreateTrade(userbuy, userbuy)) {
						transaction tst = new transaction();
						String code = randomString(8);
						String createby = giaodich.getNguoitao();

						users user = new users();
						user = Ruser.findByUsernameLike(createby);
						Long createid = user.getId();

						int fee = 0; // final
						int statussell = 0;
						int statusbuy = 0;
						LocalDate datenow = LocalDate.now();
						LocalTime timenow = LocalTime.now();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String Sdate = datenow.toString() + " " + timenow.toString();
						Date createdate = new Date();

						try {
							createdate = formatter.parse(Sdate);
						} catch (ParseException e) {
							e.printStackTrace();
						}

						LocalDate modifieddate = null;
						String modifiedby = null;
						int status = 1;
						// random code
						tst.setId(null);
						tst.setCode(code);
						tst.setUsersell(usersell);
						tst.setUserbuy(userbuy);
						tst.setCreateid(createid);
						tst.setPrice(price);
						tst.setFee(fee);
						tst.setMinutes(minutes);
						tst.setTitle(title);
						tst.setStatussell(statussell);
						tst.setStatusbuy(statusbuy);
						tst.setCreatedate(createdate);
						tst.setCreateby(createby);
						tst.setModifieddate(modifieddate);
						tst.setModifiedby(modifiedby);
						tst.setStatus(status);

						Rtransaction.save(tst);

						// message = "success";
					} else {
						message = "người bán hoặc người mua đã vượt quá 10 lần giao dịch trong ngày.";
					}

				} else {
					message = "có lỗi xảy ra";
				}

			} else {
				message = "có lỗi xảy ra";
			}
		} catch (Exception e) {
			// TODO: handle exception
			message = "đã xảy ra lỗi";
		}

		return message;
	}

	@Override
	public String createCmt(comments cmt) {
		// TODO Auto-generated method stub
		String message = "success";
		try {
			if (cmt.getContents().length() < 200 && cmt.getContents().length() > 4 && !checkXss(cmt.getContents())) {
				cmt.setId(null);

				LocalDate datenow = LocalDate.now();
				LocalTime timenow = LocalTime.now();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String Sdate = datenow.toString() + " " + timenow.toString();
				Date createdate = new Date();
				cmt.setCreatedate(createdate);

				Rcomments.save(cmt);
			} else
				message = "có lỗi xảy ra";
		} catch (Exception e) {
			// TODO: handle exception
			message = "có lỗi xảy ra";
		}

		return message;
	}

	@Override
	public String updateTrade(Long id, String status, String username) {
		// TODO Auto-generated method stub
		String message = "success";
		int flag = Integer.parseInt(status);
		transaction trade = Rtransaction.getById(id);
		int buy = trade.getStatusbuy();
		int sell = trade.getStatussell();
		try {
			if (this.trangthaigiaodich(id) == 0) {
				if (buy > -2 && sell > -2) {
					if (sell != 1 && flag == 1 && username.equals(trade.getUserbuy())) {
						return "có lỗi xảy ra";
					} else {
						if (username.equals(trade.getUserbuy())) {
							trade.setStatusbuy(flag);
						} else if (username.equals(trade.getUsersell())) {
							trade.setStatussell(flag);
						}
					}

					Rtransaction.save(trade);
				} else
					message = "có lỗi xảy ra";
			} else
				message = "có lỗi xảy ra";
		} catch (Exception e) {
			// TODO: handle exception
			message = "có lỗi xảy ra";
		}

		return message;
	}

	@Override
	public int trangthaigiaodich(Long id) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			String username = "";
			transaction trade = Rtransaction.getById(id);
			Thongtingiaodich ttgd = this.getMyTrade(username, id);
			int buy = trade.getStatusbuy();
			int sell = trade.getStatussell();
			if (buy < -1 || sell < -1)
				flag = -1;
			if (ttgd.getSophutconlai() < 1)
				flag = -1;
			if (buy == 1 && sell == 1)
				flag = -1;
			if (buy == 0 || buy == -1)
				flag = -1;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return flag;
	}

	@Override
	public String register(dangkyDTO dangky) {
		// TODO Auto-generated method stub
		String message = "success";
		try {
			if (!dangky.empty() && dangky.matkhaunhaplai()) {
				if (dangky.kiemtra(dangky.getTaikhoan()) && dangky.kiemtra(dangky.getMatkhau())
						&& dangky.kiemtraSDT(dangky.getSodienthoai()) && dangky.kiemtraGmail(dangky.getGmail())) {
					if (Ruser.countByUsername(dangky.getTaikhoan()) == 0) {

						users user = new users();
						user.setId(null);
						user.setUsername(dangky.getTaikhoan());
						// --------ma hoa
						BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
						String encodedPassword = bCryptPasswordEncoder.encode(dangky.getMatkhau());
						user.setPassword(encodedPassword);
						// System.out.println(dangky.getMatkhau());

						user.setPhonenumber(dangky.getSodienthoai());
						user.setEmail(dangky.getGmail());
						user.setPoint(0);
						user.setStatus(1);
						user.setCreateby(null);
						user.setModifiedby(null);
						user.setModifieddate(null);

						LocalDate datenow = LocalDate.now();
						LocalTime timenow = LocalTime.now();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String Sdate = datenow.toString() + " " + timenow.toString();
						Date createdate = new Date();
						user.setCreatedate(createdate);

						Ruser.save(user);

						users userRole = Ruser.findByUsernameLike(dangky.getTaikhoan());
						role ro = new role();

						ro.setId(null);
						ro.setUserid(userRole.getId());
						ro.setUserrole(1);
						ro.setCreateby(dangky.getTaikhoan());
						ro.setCreatedate(createdate);
						ro.setModifiedby(null);
						ro.setModifieddate(null);

						Rrole.save(ro);
					} else
						message = "có lỗi xảy ra";
				} else
					message = "có lỗi xảy ra";
			} else
				message = "có lỗi xảy ra";
		} catch (Exception e) {
			message = "có lỗi xảy ra";
		}

		return message;
	}

	@Override
	public boolean confirm(Long id) {
		// TODO Auto-generated method stub
		try {
			transaction tran = new transaction();
			tran = Rtransaction.getById(id);
			if (tran.getStatusbuy() == 2)
				tran.setStatusbuy(0);
			else
				tran.setStatusbuy(2);
			Rtransaction.save(tran);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public List<transaction> getHomePageAdmin(int start, int limit) {
		Pageable pageable = PageRequest.of(start, limit);
		List<transaction> pagettgd = Rtransaction.findAllByOrderByCreatedateDesc(pageable).getContent();

		return pagettgd;
	}

	@Override
	public boolean updateMomo(String sdt) {
		// TODO Auto-generated method stub
		try {
			momo entity = new momo();
			List<momo> list = Rmomo.findAll();
			for (momo o : list)
				if (o.getStatus() == 1)
					entity = o;

			entity.setAccount(sdt);
			Rmomo.save(entity);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return true;
	}

	@Override
	public boolean changePassword(Long id, String newpassword) {
		// TODO Auto-generated method stub
		boolean flag = false;

		users user = new users();
		user = Ruser.getById(id);
		dangkyDTO dangky = new dangkyDTO();
		if (dangky.kiemtra(newpassword)) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = bCryptPasswordEncoder.encode(newpassword);
			user.setPassword(encodedPassword);
			Ruser.save(user);
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean updatebank(String username, String namebank, String numbank) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			if (namebank.length() > 1 && namebank.length() < 50 && !checkXss(namebank) && numbank.length() > 1
					&& numbank.length() < 30 && !checkXss(numbank)) {
				userbank user = new userbank();
				if(Ruserbank.findByUsernameLike(username) != null)
					user = Ruserbank.findByUsernameLike(username);
				user.setUsername(username);
				user.setNamebank(namebank);
				user.setNumbank(numbank);
				user.setCreateby(username);
				
				LocalDate datenow = LocalDate.now();
				LocalTime timenow = LocalTime.now();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String Sdate = datenow.toString() + " " + timenow.toString();
				Date createdate = new Date();
				user.setCreatedate(createdate);
				
				Ruserbank.save(user);
			} else
				flag = false;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}

		return flag;
	}

	@Override
	public String getUserbank(String username) {
		// TODO Auto-generated method stub
		String strbank = "";
		
		try {
			userbank user = new userbank();
			user = Ruserbank.findByUsernameLike(username);
			strbank = user.getNamebank() + ": " + user.getNumbank(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return strbank;
	}

//	@Override
//	public List<transaction> findallgdct(String username) {
//		// TODO Auto-generated method stub
//		return Rtransaction.findAllByUsersellOrUserbuyOrderByCreatedateDesc(username, username);
//	}

}
