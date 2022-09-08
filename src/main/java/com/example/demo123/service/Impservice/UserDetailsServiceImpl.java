package com.example.demo123.service.Impservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo123.models.users;
import com.example.demo123.repositories.roleRps;
import com.example.demo123.repositories.userRps;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private userRps Ruser;
	
	@Autowired
	private roleRps Rrole;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		users user = Ruser.findByUsernameLike(username);
		int role = 1;
		role = Rrole.getByUserid(user.getId()).getUserrole();
//        if (user == null) {
//            System.out.println("User not found! " + username);
//            throw new UsernameNotFoundException("User " + username + " was not found in the database");
//        }
//        System.out.println("Found User: " + user);

        // [ROLE_USER, ROLE_ADMIN,..]
        		//this.Rrole.getByUserid(user.getId());
        //List<String> roleNames = new ArrayList<>();
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(role == 1) {
        	GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        	grantList.add(authority);
        }
        if(role == 0) {
        	GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        	grantList.add(authority);
        }

        UserDetails userDetails = new User(user.getUsername(), //
                user.getPassword(), grantList);

        return userDetails;
	}

}
