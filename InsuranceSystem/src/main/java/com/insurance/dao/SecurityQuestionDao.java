package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

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
}
