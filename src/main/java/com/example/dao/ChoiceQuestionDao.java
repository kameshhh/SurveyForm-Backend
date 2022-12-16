package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.ChoiceQuestions;
import com.example.entities.CustomerAnswers;
import com.example.entities.Users;

@Repository
public interface ChoiceQuestionDao extends JpaRepository<ChoiceQuestions,Integer> {

	List<ChoiceQuestions> findBySid(int sid);

	public ChoiceQuestions findBysid(int sid);

}
