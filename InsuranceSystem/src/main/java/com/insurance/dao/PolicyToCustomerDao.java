package com.insurance.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.insurance.data.PolicyToCustomerDB;

@Repository
public class PolicyToCustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<PolicyToCustomerDB> listPolicyToCustomer(){
		Session session = sessionFactory.openSession();
		List<PolicyToCustomerDB> list;
		try {
			list = session.createQuery("from PolicyToCustomerDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void addPolicyToCustomer(PolicyToCustomerDB pc){
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(pc);
		transaction.commit();
		session.close();
	}
	

}
