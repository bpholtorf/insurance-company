package com.insurance.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.AnswerDB;

@Repository
public class AnswerDao {
 
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<AnswerDB> listAnswer(){
		Session session = sessionFactory.openSession();
		List<AnswerDB> list;
		try {
			list = session.createQuery("from AnswerDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void addAnswer(AnswerDB answer){
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(answer);
		transaction.commit();
		session.close();
	}
	
	public List<AnswerDB> findQuestionsBysid(int sid)
	{
		Session session = sessionFactory.openSession();
		List<AnswerDB> list=new ArrayList<AnswerDB>();
		try {
			String hqlString="FROM AnswerDB where sid=:sid";
			Query query=session.createQuery(hqlString);
			query.setInteger("sid", sid);
			list = query.list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<AnswerDB> findById(int sid,int qid)
	{
		Session session = sessionFactory.openSession();
		List<AnswerDB> list=new ArrayList<AnswerDB>();
		try {
			String hqlString="FROM AnswerDB where sid=:sid AND qid=:qid";
			Query query=session.createQuery(hqlString);
			query.setInteger("sid", sid);
			query.setInteger("qid", qid);
			list = query.list();
		} finally {
			session.close();
		}
		return list;
	}
	
}

