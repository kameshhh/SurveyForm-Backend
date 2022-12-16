package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.AdminUser;
import com.example.entities.Users;
import com.example.service.AdminUserService;
import com.example.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminControllers {
	
	@Autowired 
	private AdminUserService adminService;
	
	@PostMapping("/adminsignup")
	public  ResponseEntity<?> signupUser(@RequestBody AdminUser userData){
		String emailId=userData.getEmail();
		if(emailId!=null && !"".equals(emailId)) {
			AdminUser userobj =adminService.findByEmailId(emailId);
			if(userobj!= null) {
				return (ResponseEntity<?>) ResponseEntity.internalServerError();
			}
			
		}
		AdminUser userObj=null;
		userObj=adminService.saveUser(userData);
		return ResponseEntity.ok(userObj);
		
	}
		@PostMapping("/adminlogin")
		public  ResponseEntity<?> loginUser(@RequestBody AdminUser userData ,HttpSession session){
			System.out.println(userData);
			AdminUser validAdmin=adminService.login(userData);
			if(validAdmin!=null) {
				session.setAttribute("user", validAdmin);
				return new ResponseEntity<AdminUser>(validAdmin,HttpStatus.OK);
			}else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
			}
		}
		@DeleteMapping("/logout")
		public ResponseEntity<?> logout(HttpSession session){
			AdminUser user=(AdminUser)session.getAttribute("user");
			if(user!=null)
				session.removeAttribute("user");
			session.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		

	}
	

