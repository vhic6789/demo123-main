package com.example.demo123.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo123.models.transaction;
import com.example.demo123.service.service1;

@RestController
public class MycontrolRest {

	@Autowired
	private service1 servicetest1;
	
	@GetMapping(path = "api/getNotifi")
	public Integer getNoti(@RequestParam(name = "name") String name) {
		Integer notifications = servicetest1.countNotiNowday(name);
		return notifications;
	}
	
	@GetMapping(path = "api/getStatus")
	public Integer getStt(@RequestParam(name = "id") Long id) {
		int ttgd = servicetest1.trangthaigiaodich(id);
		return ttgd;
	}
	
//	@GetMapping(path = "api/getAllTrade")
//	public List<transaction> getall(@RequestParam(name = "name") String username) {
//		//String username = "anhvu";
//		return servicetest1.findallgdct(username);
//	}
}
