package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.AdminUser;

@Repository
public interface AdminUserDao extends JpaRepository<AdminUser, Integer> {
	public AdminUser findByEmail(String email);
	 
	 public AdminUser findByEmailAndPassword(String email, String password);

}
