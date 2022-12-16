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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.AdminQuestions;

import com.example.service.AdminService;

@RestController
@RequestMapping("/adminquestions")

@CrossOrigin(origins="http://localhost:4200")
public class AdminQuestionsControllers {
	
	
	@Autowired
	private AdminService userService;
	
//	@Autowired
//	private ChoiceQuestionsService choiceService;
//	
//	@PostMapping("/choicequestions")
//	public  ResponseEntity<?> saveChoiceQuestion(@RequestBody ChoiceQuestions quesData){
//		ChoiceQuestions userObj=null;
//		userObj=choiceService.saveChoiceQuestion(quesData);
//		return ResponseEntity.ok(userObj);
//	}
	
	@PostMapping("/surveyquestions")
	public  ResponseEntity<?> saveQuestions(@RequestBody AdminQuestions quesData){
		AdminQuestions userObj=null;
		userObj=userService.saveQuestion(quesData);
		return ResponseEntity.ok(userObj);
		
	}
	
	@GetMapping("/allsurveys")
	public ResponseEntity<?> getAllServeys(){
			List<AdminQuestions> userdetails=userService.getAllServeys();
			return new ResponseEntity<List<AdminQuestions>>(userdetails,HttpStatus.OK);
	}
	@GetMapping("/survey/{id}")
	public ResponseEntity<?> getSurveyById(@PathVariable int id){
		Optional<AdminQuestions> surveydetails=null;
			surveydetails =userService.getSurveyById(id);
			return new ResponseEntity<Optional<AdminQuestions>>(surveydetails,HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteSurvey(@PathVariable int id){
			userService.deleteSurveyById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
