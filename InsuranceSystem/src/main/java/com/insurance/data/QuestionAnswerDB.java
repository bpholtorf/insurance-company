package com.insurance.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_answer")
public class QuestionAnswerDB implements Serializable{
	@Id
	@Column(name="qid")
	private int qid;
	
	@Column(name="sid")
	private int sid;
	
	@Column(name="answer")
	private String answer;
	
	public int getQid(){
		return qid;
	}
	public void setQid(int qid){
		this.qid=qid;
	}
	
	public int getSid(){
		return sid;
	}
	public void setSid(int sid){
		this.sid=sid;
	}
	
	public String getAnswer(){
		return answer;
	}
	public void setAnswer(String answer){
		this.answer=answer;
	}

}
