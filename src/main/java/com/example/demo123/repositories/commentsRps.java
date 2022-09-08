package com.example.demo123.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo123.models.comments;

public interface commentsRps extends JpaRepository<comments, Long> {
	public List<comments> getByTransactionid(Long id);
}
