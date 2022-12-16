
package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.example.dao.AdminDao;
import com.example.entities.AdminQuestions;
//import com.example.dao.ContactUsDao;
//import com.example.dao.GetRechHistoryDao;
//import com.example.dao.NewUserDao;
//import com.example.entities.ContactUs;
//import com.example.entities.RechargeHistory;
//import com.example.entities.Users;
import com.example.entities.ChoiceQuestions;
//import com.example.entities.PostpaidPlans;

@Service
@Transactional
public class AdminService {
	

		public AdminService() {
			System.out.println("<<<<<<<<<<<<<<<POST SERVICE INSTANTIATED>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		
		@Autowired
		AdminDao questions;
		

	public AdminQuestions saveQuestion(AdminQuestions quesData) {
		// TODO Auto-generated method stub
		questions.save(quesData);
		return quesData;
	}

	public List<AdminQuestions> getAllServeys(){
		return questions.findAll();
	}
//
//	public Optional<AdminQuestions> getSurveyById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public Optional<AdminQuestions> getSurveyById(int id){
		return questions.findById(id);
	}

	public void deleteSurveyById(int id) {
		// TODO Auto-generated method stub
		questions.deleteById(id);
	}
	
//	public List<AdminQuestions> getAllSurveys() {
//		// TODO Auto-generated method stub
//		return questions.findAll();
//	}
	
//	public List<RechargeHistory> getRechargeHistoryByEmail(Users users) {
////		 TODO Auto-generated method stub
//		return recharge.findHistoryByEmailId(email);
////		return null;
//	}
	
//	public List<RechargeHistory> getRechargeHistoryByEmail(String email){
//		return recharge.findHistoryByEmailId(email);
//	}
	
	
	
	
	}