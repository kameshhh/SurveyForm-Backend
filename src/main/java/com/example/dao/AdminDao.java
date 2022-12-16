package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.AdminQuestions;

@Repository
public interface AdminDao extends JpaRepository<AdminQuestions, Integer> {

}
