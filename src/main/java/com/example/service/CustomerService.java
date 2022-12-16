package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AdminDao;
import com.example.dao.CustomerDao;
import com.example.entities.AdminQuestions;
import com.example.entities.CustomerAnswers;


@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerDao  answers;
	

	public CustomerAnswers saveAnswers(CustomerAnswers quesData) {
		// TODO Auto-generated method stub
		answers.save(quesData);
		return quesData;
		}
	

	

}
