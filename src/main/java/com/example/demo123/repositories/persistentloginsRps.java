package com.example.demo123.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo123.models.persistentlogins;

public interface persistentloginsRps extends JpaRepository<persistentlogins, Long> {

}
