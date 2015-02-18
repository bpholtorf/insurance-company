package com.insurance.service;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.AnswerDao;
import com.insurance.dao.SecurityQuestionDao;
import com.insurance.data.AnswerDB;
import com.insurance.data.QuestionAnswer;

@Service
public class AnswerService {
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private SecurityQuestionDao securityQuestionDao;
	public void addAnswer(AnswerDB answer){
		answerDao.addAnswer(answer);
	}
	
	public QuestionAnswer findBysid(int sid)
	{
		List<AnswerDB> list=answerDao.findQuestionsBysid(sid);
		
		//generate random question
		Random r = new Random();
		int Low = 0;
		int High = 2;
		int R = r.nextInt((High-Low)+1) + Low;
		AnswerDB answerDB=list.get(R);
		String answer=answerDB.getAnswer();
		int qid=answerDB.getQid();
		String question=securityQuestionDao.findByqid(qid).getQuestion();
		System.out.println(new QuestionAnswer(question, answer).toString());
		return new QuestionAnswer(question, answer);
		
	}
	
	public String findSid(int sid){
		List<AnswerDB> list=answerDao.findQuestionsBysid(sid);
		if(list.isEmpty()){
			return "NO";
		}else{
			return "YES";
		}
	}
}
