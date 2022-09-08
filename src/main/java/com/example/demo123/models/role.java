package com.example.demo123.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class role extends base {

	private Long userid;
	private int userrole; //1-user, 0-admin
  
	
	public role() {
		
	}
	
	public role(Long userid, int userrole) {
	
		this.userid = userid;
		this.userrole = userrole;
	}

	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public int getUserrole() {
		return userrole;
	}
	public void setUserrole(int userrole) {
		this.userrole = userrole;
	}
	
}