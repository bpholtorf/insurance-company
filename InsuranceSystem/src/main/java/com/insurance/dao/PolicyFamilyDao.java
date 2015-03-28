package com.insurance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.PolicyFamilyDB;


@Repository
public class PolicyFamilyDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<PolicyFamilyDB> listMembers(){
		Session session = sessionFactory.openSession();
		List<PolicyFamilyDB> list;
		try {
			list = session.createQuery("from PolicyFamilyDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void addMember(PolicyFamilyDB pf){
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(pf);
		transaction.commit();
		session.close();
	}
	

}
