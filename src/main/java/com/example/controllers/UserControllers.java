package com.example.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.Users;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserControllers {
	
	@Autowired 
	private UserService userService;
	
	
	@PostMapping("/signup")
	public  ResponseEntity<?> signupUser(@RequestBody Users userData){
		String emailId=userData.getEmail();
		if(emailId!=null && !"".equals(emailId)) {
		Users userobj =userService.findByEmailId(emailId);
			if(userobj!= null) {
				return (ResponseEntity<?>) ResponseEntity.internalServerError();
			}
			
		}
		Users userObj=null;
		userObj=userService.saveUser(userData);
		return ResponseEntity.ok(userObj);
		
	}
		
	
	@PostMapping("/userlogin")
	public  ResponseEntity<?> loginUser(@RequestBody Users userData ,HttpSession session){
		System.out.println(userData);
		Users validUser=userService.login(userData);
		if(validUser!=null) {
			session.setAttribute("user", validUser);
			return new ResponseEntity<Users>(validUser,HttpStatus.OK);
		}else {
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

	@DeleteMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session){
		Users user=(Users)session.getAttribute("user");
		if(user!=null)
			session.removeAttribute("user");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@GetMapping("/alluserdetails")
	public ResponseEntity<?> getAllUserdetails(){
			List<Users> userdetails=userService.getAllUserdetails();
			return new ResponseEntity<List<Users>>(userdetails,HttpStatus.OK);
		
	}
	
	
		@GetMapping("/getuserdetails/{id}")
		public ResponseEntity<?> getUserdetailsByID(@PathVariable int id){
			Optional<Users> userdetails=null;
				userdetails =userService.getUserdetailsById(id);
				return new ResponseEntity<Optional<Users>>(userdetails,HttpStatus.OK);
	    }
		
		
		@PutMapping("/update")
		public ResponseEntity<?> updateuserdetails(@RequestBody Users userdetails){
			userService.updateuserdetails(userdetails);
				return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?>deleteUserdetails(@PathVariable int id){
			userService.deleteUserdetails(id);
				return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		
}
