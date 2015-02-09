package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.SecurityQuestionDB;

@Repository
public class SecurityQuestionDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<SecurityQuestionDB> findAll()
	{
		Session session=sessionFactory.openSession();
		List<SecurityQuestionDB> list=new ArrayList<SecurityQuestionDB>();
		try{
			list=session.createQuery("from SecurityQuestionDB").list();			
			}finally{
				session.close();
			}
		return list;
	}
	
	public SecurityQuestionDB findByqid(int id)
	{
		Session session = sessionFactory.openSession();
		List<SecurityQuestionDB> list=new ArrayList<SecurityQuestionDB>();
		try {
			String hqlString="from SecurityQuestionDB where questionId = :questionId";
			Query query=session.createQuery(hqlString);
			query.setInteger("questionId", id);
			list = query.list();
			
		} finally {
			session.close();
		}
		
		System.out.println(list.get(0).toString());
		return list.get(0);
	}
}
