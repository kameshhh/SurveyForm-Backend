package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.AdminQuestions;
import com.example.entities.ChoiceQuestions;
import com.example.entities.Users;
import com.example.service.ChoiceQuestionService;

@RestController
@RequestMapping("/choicequestions")

@CrossOrigin(origins="http://localhost:4200")
public class ChoiceQuestionsController {
	
	@Autowired
	private ChoiceQuestionService choiceService;
	
	@PostMapping("/choicequestions/{sid}")
	public  ResponseEntity<?> saveQuestions(@RequestBody ChoiceQuestions quesData,@PathVariable int sid){
		quesData.setSid(sid);
		ChoiceQuestions idobj=null;
		idobj=choiceService.saveQuestion(quesData);
		return ResponseEntity.ok(idobj);
		
	}
	
	@GetMapping("/allsurveys")
	public ResponseEntity<?> getAllServeys(){
			List<ChoiceQuestions> userdetails=choiceService.getAllServeys();
			return new ResponseEntity<List<ChoiceQuestions>>(userdetails,HttpStatus.OK);
	}
	
	@GetMapping("/chquestion/{id}")
	public ResponseEntity<?> getchQuesById(@PathVariable int id){
		Optional<ChoiceQuestions> surveydetails=null;
			surveydetails =choiceService.getchQuesById(id);
			return new ResponseEntity<Optional<ChoiceQuestions>>(surveydetails,HttpStatus.OK);
    }
	
	@GetMapping("/choicequestionbyid/{sid}")
	public  ResponseEntity<?> getRechargeHistoryByIdEmail(@PathVariable int sid){
		List<ChoiceQuestions> userdetails=null;
		System.out.println(sid);
		userdetails =choiceService.getQuestionBySid(sid);
		return new ResponseEntity<List<ChoiceQuestions>>(userdetails,HttpStatus.OK);
		
	}
	
//	@PostMapping("/createchoicequestion/{sid}")
//	public  ResponseEntity<?> createQuestion(@PathVariable int sid){
//		
//		List<ChoiceQuestions> userdetails=null;
//		System.out.println(sid);
//		userdetails =choiceService.getQuestionBySid(sid);
//		return new ResponseEntity<List<ChoiceQuestions>>(userdetails,HttpStatus.OK);
//		
//	}
	
	
//	@PostMapping("/signup")
//	public  ResponseEntity<?> signupUser(@RequestBody Users userData){
//		String emailId=userData.getEmail();
//		if(emailId!=null && !"".equals(emailId)) {
//		Users userobj =userService.findByEmailId(emailId);
//			if(userobj!= null) {
//				return (ResponseEntity<?>) ResponseEntity.internalServerError();
//			}
//			
//		}
//		Users userObj=null;
//		userObj=userService.saveUser(userData);
//		return ResponseEntity.ok(userObj);
//		
//	}
//	
//		
//	

}
