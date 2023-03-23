package com.example.demo123.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo123.dto.GiaodichDTO;
import com.example.demo123.dto.Thongtincanhan;
import com.example.demo123.dto.Thongtingiaodich;
import com.example.demo123.dto.dangkyDTO;
import com.example.demo123.models.comments;
import com.example.demo123.models.transaction;
import com.example.demo123.service.service1;

@Controller
public class MyControl {

	@Autowired
	private service1 servicetest;

	@GetMapping(path = { "index", "" })
	public String index(Model model, Principal principal, @RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "error", defaultValue = "0") int error) {

		int size = 10;
		List<Thongtingiaodich> pages;
		try {
			pages = servicetest.getHomePage(page - 1, size);
			model.addAttribute("ttgds", pages);
			model.addAttribute("pageNumber", page);
		} catch (Exception e) {
			// TODO: handle exception
			page = 1;
			pages = servicetest.getHomePage(page - 1, size);
			model.addAttribute("ttgds", pages);
			model.addAttribute("pageNumber", page);
		}

		if (error != 0)
			model.addAttribute("error", error);

		if (principal != null)
			return "redirect:/user/home";
		return "index";
	}

	@GetMapping(path = "user/home")
	public String userHome(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {

		int size = 10;
		List<Thongtingiaodich> pages;
		try {
			pages = servicetest.getHomePage(page - 1, size);
			model.addAttribute("ttgds", pages);
			model.addAttribute("pageNumber", page);
		} catch (Exception e) {
			// TODO: handle exception
			page = 1;
			pages = servicetest.getHomePage(page - 1, size);
			model.addAttribute("ttgds", pages);
			model.addAttribute("pageNumber", page);
		}

		model.addAttribute("titlePage", "home");

		return "home";
	}

	@GetMapping(path = "user/profile")
	public String profile(Model model, Principal principal, @RequestParam(name = "name") String name,
			@RequestParam(name = "change", defaultValue = "0") String change) {

		String username = principal.getName();
		int status = 0;
		if (name.equals(username))
			status = 1;
		model.addAttribute("status", status);

		Thongtincanhan requestname = servicetest.getDetailUser(name);
		model.addAttribute("requestname", requestname);

		Thongtincanhan ttcn = new Thongtincanhan();
		ttcn = servicetest.getDetailUser(username);
		model.addAttribute("user", ttcn);

		model.addAttribute("titlePage", "trang cá nhân");

		String stk = "";
		stk = servicetest.getUserbank(username);
		model.addAttribute("sotaikhoan", stk);
		
		if(change.equals("-1"))
			model.addAttribute("notifiChange", "thay đổi không thành công");
		else if(change.equals("1"))
			model.addAttribute("notifiChange", "Thành công");
		
		return "profile";
	}

	@GetMapping(path = "user/buyer")
	public String buyer(Model model, Principal principal) {
		model.addAttribute("titlePage", "mua");

		return "buyer";
	}

	@PostMapping(path = "user/buyer")
	public String buyerPost(Model model, Principal principal, @RequestParam(name = "title") String title,
			@RequestParam(name = "sellname") String sellname, @RequestParam(name = "price") String price,
			@RequestParam(name = "hour") String hour, @RequestParam(name = "minutes") String minutes) {

		String myname = principal.getName();
		String message = "";

		GiaodichDTO giaodich = new GiaodichDTO();
		giaodich.setTieude(title);
		giaodich.setNguoiban(sellname);
		giaodich.setNguoimua(myname);
		giaodich.setNguoitao(myname);
		giaodich.setGiatri(price);
		giaodich.setHour(hour);
		giaodich.setMinutes(minutes);

		message = servicetest.createTrade(giaodich);
		model.addAttribute("message", message);

		if (message.equals("success")) {
			return "redirect:/user/allmytrade?page=1";
		}

		return "buyer";
	}

	@GetMapping(path = "user/seller")
	public String seller(Model model, Principal principal) {
		model.addAttribute("titlePage", "bán");

		return "seller";
	}

	@PostMapping(path = "user/seller")
	public String sellerPost(Model model, Principal principal, @RequestParam(name = "title") String title,
			@RequestParam(name = "buyname") String buyname, @RequestParam(name = "price") String price,
			@RequestParam(name = "hour") String hour, @RequestParam(name = "minutes") String minutes) {

		String myname = principal.getName();

		GiaodichDTO giaodich = new GiaodichDTO();
		giaodich.setTieude(title);
		giaodich.setNguoiban(myname);
		giaodich.setNguoimua(buyname);
		giaodich.setNguoitao(myname);
		giaodich.setGiatri(price);
		giaodich.setHour(hour);
		giaodich.setMinutes(minutes);

		String message = "";
		message = servicetest.createTrade(giaodich);
		model.addAttribute("message", message);

		if (message.equals("success"))
			return "redirect:/user/allmytrade?page=1";

		return "seller";
	}

	@GetMapping(path = "user/allmytrade")
	public String allmytrade(Model model, Principal principal,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		int limit = 5;
		List<Thongtingiaodich> pages;
		String username = principal.getName();
		try {
			pages = servicetest.getAllMyTradePage(username, page - 1, limit);
			model.addAttribute("ttgds", pages);
			model.addAttribute("pageNumber", page);
		} catch (Exception e) {
			// TODO: handle exception
			page = 1;
			pages = servicetest.getAllMyTradePage(username, page - 1, limit);
			model.addAttribute("ttgds", pages);
			model.addAttribute("pageNumber", page);
		}
		model.addAttribute("titlePage", "tất cả giao dịch");

		return "allmytrade";
	}

	@GetMapping(path = "user/mytrade/{id}/active")
	public String mytrade(Model model, Principal principal,
			@RequestParam(name = "error", defaultValue = "false") String error, @PathVariable Long id) {

		String Username = principal.getName();
		Thongtingiaodich ttgd = servicetest.getMyTrade(Username, id);
		model.addAttribute("mytrade", ttgd);

		String message = "";
		if (ttgd.getTrangthaimua().equals("chưa chuyển tiền"))
			message = "(giao dịch chưa bắt đầu - do người mua chưa chuyển tiền)";
		model.addAttribute("message", message);

		List<comments> cmts = new ArrayList<>();
		cmts = servicetest.getAllCommentsByTransactionid(id);
		model.addAttribute("cmts", cmts);

		String chuyenkhoanMomo = "";
		chuyenkhoanMomo = servicetest.getSdtMomo();
		model.addAttribute("chuyenkhoan", chuyenkhoanMomo);

		if (error.equals("true")) {
			model.addAttribute("error", "có lỗi xảy ra");
		}
		model.addAttribute("titlePage", "giao dịch của tôi");
		model.addAttribute("checkcssmytrade", "/fileinclude/css/mytradecss.css");
		return "mytrade";
	}

	@PostMapping(path = "user/mytrade")
	public String sendmessagePost(Model model, RedirectAttributes rd, Principal principal,
			@RequestParam(name = "contents") String contents, @RequestParam(name = "id") Long id,
			@RequestParam(name = "huygiaodich", defaultValue = "0") String huygiaodich,
			@RequestParam(name = "khieunai", defaultValue = "0") String khieunai,
			@RequestParam(name = "xacnhan", defaultValue = "0") String xacnhan) {
		String username = principal.getName();
		String messageTrade = "";
		String messageCmt = "";

		if (huygiaodich.equals("0") && khieunai.equals("0") && xacnhan.equals("0")) {
			comments cmt = new comments();
			cmt.setContents(contents);
			cmt.setCreateby(username);
			cmt.setTransactioncode(id);
			messageCmt = servicetest.createCmt(cmt);
		}

		if (huygiaodich.equals("-2") && khieunai.equals("0") && xacnhan.equals("0")) {
			messageTrade = servicetest.updateTrade(id, huygiaodich, username);
		}

		if (huygiaodich.equals("0") && khieunai.equals("-3") && xacnhan.equals("0")) {
			messageTrade = servicetest.updateTrade(id, khieunai, username);
		}

		if (huygiaodich.equals("0") && khieunai.equals("0") && xacnhan.equals("1")) {
			messageTrade = servicetest.updateTrade(id, xacnhan, username);
		}

		String error = messageTrade + messageCmt;
		String url = "redirect:user/mytrade/" + id.toString() + "/active?error=" + (error);

		if (!error.equals("success"))
			url = "redirect:/user/mytrade/" + id.toString() + "/active?error=true";
		else
			url = "redirect:/user/mytrade/" + id.toString() + "/active";

		return url;
	}

	@GetMapping(path = "/403")
	public String accessDenied(Model model, Principal principal) {

		if (principal != null)
			model.addAttribute("message", "Không thể truy cập");

		return "403Page";
	}

	@GetMapping(path = "admin/home")
	public String homePageAdmin(Model model, Principal principal,
			@RequestParam(name = "page", defaultValue = "1") int page) {

		int size = 10;
		List<transaction> pages;
		try {
			pages = servicetest.getHomePageAdmin(page - 1, size);
			model.addAttribute("ttgds", pages);
			model.addAttribute("pageNumber", page);
		} catch (Exception e) {
			// TODO: handle exception
			page = 1;
			pages = servicetest.getHomePageAdmin(page - 1, size);
			model.addAttribute("ttgds", pages);
			model.addAttribute("pageNumber", page);
		}
		model.addAttribute("titlePage", "error");

		return "adminHome";
	}

	@PostMapping(path = "admin/confirm")
	public String confirmTrade(@RequestParam(name = "id") Long id) {
		boolean a = servicetest.confirm(id);
		return "redirect:/admin/home?page=1";
	}

	@PostMapping(path = "register")
	public String register(Model model, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "passwordagain") String passwordagain,
			@RequestParam(name = "phonenumber") String phonenumber, @RequestParam(name = "email") String email) {
		String message = "";

		dangkyDTO dangky = new dangkyDTO();
		dangky.setTaikhoan(username);
		dangky.setMatkhau(password);
		dangky.setNhaplaimatkhau(passwordagain);
		dangky.setSodienthoai(phonenumber);
		dangky.setGmail(email);

		message = servicetest.register(dangky);

		String url = "";
		if (message.equals("success"))
			url = "redirect:/index?error=1";
		else
			url = "redirect:/index?error=-1";
		return url;
	}

	@GetMapping(path = "user/thongbao")
	public String thongbao(Model model, Principal principal) {
		model.addAttribute("titlePage", "thông báo");

		return "thongbao";
	}

	@GetMapping(path = "admin/manager")
	public String manager(Model model, @RequestParam(name = "username", defaultValue = "") String username) {
		String stk = "";
		stk = servicetest.getUserbank(username);
		model.addAttribute("stk", stk);
		Thongtincanhan ttcn = new Thongtincanhan();
		ttcn = servicetest.getDetailUser(username);
		model.addAttribute("ttcn", ttcn);
		
		String sdt = servicetest.getSdtMomo();
		model.addAttribute("getSdt", sdt);
		return "manager";
	}

	@PostMapping(path = "admin/updatemomo")
	public String updateMomo(@RequestParam(name = "sdt") String sdt) {
		boolean a = servicetest.updateMomo(sdt);
		return "redirect:/admin/manager?username=";
	}

	@GetMapping(path = "/forgotpwd")
	public String forgotpass() {
		return "forgotPassword";
	}

	@PostMapping(path = "user/changePwd")
	public String changePwd(Principal principal, @RequestParam(name = "newpassword") String newpassword) {
		Thongtincanhan ttcn = servicetest.getDetailUser(principal.getName());
		boolean flag = servicetest.changePassword(ttcn.getId(), newpassword);
		String path = "";
		if (flag)
			path = "redirect:/user/profile?name=" + principal.getName() + "&change=1";
		else
			path = "redirect:/user/profile?name=" + principal.getName() + "&change=-1";

		return path;
	}
	
	@PostMapping(path = "user/updatebank")
	public String updatebank(Principal principal, @RequestParam(name = "namebank") String namebank, @RequestParam(name = "numbank") String numbank) {
		String username = principal.getName();
		boolean flag = servicetest.updatebank(username, namebank, numbank);
		String path = "";
		if (flag)
			path = "redirect:/user/profile?name=" + principal.getName() + "&change=1";
		else
			path = "redirect:/user/profile?name=" + principal.getName() + "&change=-1";

		return path;
	}
}
