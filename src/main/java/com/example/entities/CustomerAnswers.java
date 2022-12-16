package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
	@Entity
	@Table(name="usersurveys")
	public class CustomerAnswers {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
	    private int sid;
		private int cid;
		private int qid;
		private String email;
		private String chquestion;
		public CustomerAnswers() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CustomerAnswers(int id, int sid ,int cid, int qid, String email, String chquestion, String choice) {
			super();
			this.id = id;
			this.sid=sid;
			this.cid = cid;
			this.qid = qid;
			this.email = email;
			this.chquestion = chquestion;
			this.choice = choice;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public int getQid() {
			return qid;
		}
		public void setQid(int qid) {
			this.qid = qid;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getChquestion() {
			return chquestion;
		}
		public void setChquestion(String chquestion) {
			this.chquestion = chquestion;
		}
		public String getChoice() {
			return choice;
		}
		public void setChoice(String choice) {
			this.choice = choice;
		}
		private String choice;
		
		
		

}
