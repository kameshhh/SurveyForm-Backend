package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AdminUserDao;
import com.example.dao.UserDao;
import com.example.entities.AdminUser;
import com.example.entities.Users;


	@Service
	@Transactional
	public class AdminUserService {
		
		@Autowired
		AdminUserDao adminUserDao;
		
		
		public AdminUser saveUser(AdminUser userData) {
			adminUserDao.save(userData);
			return userData;
		}
		public AdminUser findByEmailId(String email) {
			return adminUserDao.findByEmail(email);
//			return ((UserService) newUserDao).findByEmail(email);			
		}
		public AdminUser login(AdminUser users) {
			return adminUserDao.findByEmailAndPassword(users.getEmail(),users.getPassword());
		}


	}

