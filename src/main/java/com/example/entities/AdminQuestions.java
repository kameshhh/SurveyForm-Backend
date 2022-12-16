


package com.example.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="surveyquestions")
public class AdminQuestions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String surveyname;
	private Date startdate;
	private Date enddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurveyname() {
		return surveyname;
	}
	public void setSurveyname(String surveyname) {
		this.surveyname = surveyname;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	public AdminQuestions(int id, String surveyname, Date startdate, Date enddate) {
		super();
		this.id = id;
		this.surveyname = surveyname;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public AdminQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
