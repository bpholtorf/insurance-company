package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.HosCoverageDB;

@Repository
public class HosCoverageDao {
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public double getDuc(String policyType, String itemName,String operatorTitle)
	{
		Session session = sessionFactory.openSession();
		List<HosCoverageDB> list=new ArrayList<HosCoverageDB>();
		try {
			
			Query query=session.createQuery("from HosCoverageDB where itemName= :itemName and operatorTitle= :operatorTitle and policyType= :policyType");
		    query.setParameter("itemName",itemName );	   
		    query.setParameter("policyType", policyType);
		    query.setParameter("operatorTitle", operatorTitle);
		    list=query.list();
		} finally {
			session.close();
		}
		return list.get(0).getDeductible();
	}
	
	
	
}
