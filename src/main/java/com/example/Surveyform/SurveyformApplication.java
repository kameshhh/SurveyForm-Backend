package com.example.Surveyform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controllers","com.example.service"})
@EntityScan(basePackages ="com.example.entities" )
@EnableJpaRepositories(basePackages="com.example.dao")
public class SurveyformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyformApplication.class, args);
	}

}
