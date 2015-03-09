package com.insurance.service;
import java.util.ArrayList;
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
	
	public List<QuestionAnswer> findBysid(int sid)
	{
		List<AnswerDB> list=answerDao.findQuestionsBysid(sid);
		List<QuestionAnswer> list1=new ArrayList<QuestionAnswer>();
		//generate random question

		for(int i=0;i<3;i++){
		AnswerDB answerDB=list.get(i);
		String answer=answerDB.getAnswer();
		int qid=answerDB.getQid();
		String question=securityQuestionDao.findByqid(qid).getQuestion();
		System.out.println(new QuestionAnswer(question, answer).toString());
		//return new QuestionAnswer(question, answer);
		list1.add(new QuestionAnswer(question, answer));
		}
		return list1;
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
