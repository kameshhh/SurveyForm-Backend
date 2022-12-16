package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entities.Users;



@Service
@Transactional
public class UserService {
	
	@Autowired
	UserDao newUserDao;
	
	
	public Users saveUser(Users userData) {
		newUserDao.save(userData);
		return userData;
	}
	public Users findByEmailId(String email) {
		return newUserDao.findByEmail(email);
//		return ((UserService) newUserDao).findByEmail(email);			
	}
	public Users login(Users users) {
		return newUserDao.findByEmailAndPassword(users.getEmail(),users.getPassword());
	}

	public List<Users> getAllUserdetails(){
		return newUserDao.findAll();
	}
	public Optional<Users> getUserdetailsById(int id){
		return newUserDao.findById(id);
	}
	public Users updateuserdetails(Users userdetails) {
		return newUserDao.save(userdetails);
	}
	public void deleteUserdetails(int id) {
		newUserDao.deleteById(id);
	}

}
