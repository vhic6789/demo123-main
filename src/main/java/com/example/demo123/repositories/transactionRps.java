package com.example.demo123.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo123.models.transaction;

public interface transactionRps extends JpaRepository<transaction, Long> {
	public List<transaction> getByCreateby(String username);
	public List<transaction> getByUsersellOrUserbuy(String namesell, String namebuy);
	public Integer countByUsersellOrUserbuy(String namesell, String namebuy);
	public Page<transaction> findAllByOrderByCreatedateDesc(Pageable pageable);
	public List<transaction> findAllByUsersellOrUserbuyOrderByCreatedateDesc(String usersell, String userbuy, Pageable pageable);
	
	@Query(value = "SELECT COUNT(id) FROM transaction WHERE createdate >= ?1 AND (usersell = ?2 OR userbuy = ?3)", nativeQuery=true)
	public Integer countAllTopNow(String datenow, String namesell, String namebuy);
	
	@Query(value = "SELECT COUNT(id) FROM transaction WHERE createdate >= ?1 AND createby = ?2", nativeQuery=true)
	public Integer countMyTopNow(String datenow, String username);
	
	@Query(value = "SELECT * FROM transaction WHERE createby <> ?1 AND (usersell = ?2 OR userbuy = ?3)", nativeQuery=true)
	public List<transaction> getAllTradeAndNotCreateby(String username, String namesell, String namebuy);
	
	@Query(value = "SELECT COUNT(id) FROM transaction WHERE createdate >= ?1 AND createby <> ?2 AND (usersell = ?3 OR userbuy = ?4)", nativeQuery=true)
	public Integer countNotificationNowday(String datenow ,String username, String namesell, String namebuy);
	
	@Query(value = "SELECT COUNT(id) FROM transaction WHERE statussell = 1 AND statusbuy = 1 AND (usersell = ?1 OR userbuy = ?2)", nativeQuery=true)
	public Integer countMyTradeTrue(String namesell, String namebuy);
	
	@Query(value = "SELECT * FROM transaction Where usersell = ?1 OR userbuy = ?2 ORDER BY id DESC LIMIT ?3,?4", nativeQuery=true)
	public List<transaction> getMyTradePage(String usersell, String userbuy, int start, int limit);
	
	@Query(value = "SELECT * FROM transaction ORDER BY id DESC", nativeQuery=true)
	public Page<transaction> getTradePageReverse(Pageable pageable);
}
