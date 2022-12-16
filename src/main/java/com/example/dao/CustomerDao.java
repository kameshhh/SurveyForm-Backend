package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.CustomerAnswers;


@Repository
public interface CustomerDao extends JpaRepository<CustomerAnswers, Integer> {
	

}
