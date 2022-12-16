package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ChoiceQuestionDao;
import com.example.entities.AdminQuestions;
import com.example.entities.ChoiceQuestions;
import com.example.entities.Users;
@Service
@Transactional
public class ChoiceQuestionService {
	
	public ChoiceQuestionService() {
		System.out.println("<<<<<<<<<<<<<<<POST SERVICE INSTANTIATED>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Autowired
	ChoiceQuestionDao choices;
	
	public ChoiceQuestions saveQuestion(ChoiceQuestions quesData) {
		// TODO Auto-generated method stub
		choices.save(quesData);
		return quesData;
	}
	
	public ChoiceQuestions findBysId(int sid) {
		return choices.findBysid(sid);
//		return ((UserService) newUserDao).findByEmail(email);			
	}
	public List<ChoiceQuestions> getAllServeys(){
		return choices.findAll();
	}

	public Optional<ChoiceQuestions> getchQuesById(int id) {
		// TODO Auto-generated method stub
		return choices.findById(id);
	}
//	public List<ChoiceQuestions> getQuestionBySid(int sid) {
//		// TODO Auto-generated method stub
//		return choices.findBySid(sid);
//	}
	public List<ChoiceQuestions> getQuestionBySid(int sid) {
		// TODO Auto-generated method stub
		return choices.findBySid(sid);
	}

}
