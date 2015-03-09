package com.insurance.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.PolicyDB;


@Repository
public class PolicyDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<PolicyDB> listPolicys(){
		Session session = sessionFactory.openSession();
		List<PolicyDB> list;
		try {
			list = session.createQuery("from PolicyDB").list();
		} finally {
			session.close();
		}
		return list;
	}


}
