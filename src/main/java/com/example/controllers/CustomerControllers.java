package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.AdminQuestions;
import com.example.entities.CustomerAnswers;
import com.example.service.AdminService;
import com.example.service.CustomerService;
	
	@RestController
	@RequestMapping("/customeranswers")

	@CrossOrigin(origins="http://localhost:4200")
	public class CustomerControllers {
		
		
		@Autowired
		private CustomerService custService;
		
//		@Autowired
//		private ChoiceQuestionsService choiceService;
	//	
//		@PostMapping("/choicequestions")
//		public  ResponseEntity<?> saveChoiceQuestion(@RequestBody ChoiceQuestions quesData){
//			ChoiceQuestions userObj=null;
//			userObj=choiceService.saveChoiceQuestion(quesData);
//			return ResponseEntity.ok(userObj);
//		}
		@PostMapping("/surveyanswers/{sid}")
		public  ResponseEntity<?> saveAnswers(@RequestBody CustomerAnswers quesData,@PathVariable int sid){
			quesData.setSid(sid);
			CustomerAnswers userObj=null;
			userObj=custService.saveAnswers(quesData);
			return ResponseEntity.ok(userObj);
			
		}

}
