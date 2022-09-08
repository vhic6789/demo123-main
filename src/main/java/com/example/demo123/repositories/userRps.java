package com.example.demo123.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.example.demo123.models.users;

public interface userRps extends JpaRepository<users, Long> {

//	@Query(value = "SELECT COUNT(id) FROM USERS",nativeQuery=true)
//	public Integer fetchUsersCount();
//	
//	@Query(value = "SELECT * FROM USERS WHERE username=(?1)",nativeQuery=true)
//	public users getByUsername(String username);

	public Integer countByUsername(String username);
	
	public users findByUsernameLike(String username);
	//public users getByUsername(String username)
}
