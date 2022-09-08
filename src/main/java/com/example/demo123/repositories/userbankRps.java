package com.example.demo123.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo123.models.userbank;

public interface userbankRps extends JpaRepository<userbank, Long> {
	public userbank findByUsernameLike(String username);
}
