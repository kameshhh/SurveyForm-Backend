package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
	
	public Users findByEmail(String email);
	 
	 public Users findByEmailAndPassword(String email, String password);

}
