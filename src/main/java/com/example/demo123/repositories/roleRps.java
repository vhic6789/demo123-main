package com.example.demo123.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo123.models.role;

public interface roleRps extends JpaRepository<role, Long> {
	public role getByUserid(Long id);
}
