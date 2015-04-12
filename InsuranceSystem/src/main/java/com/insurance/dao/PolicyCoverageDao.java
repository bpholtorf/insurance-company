package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.insurance.data.PolicyCoverage;

@Repository
public class PolicyCoverageDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean isCovered(int pid, String itemName)
	{
		Session session = sessionFactory.openSession();
		List<PolicyCoverage> list=new ArrayList<PolicyCoverage>();
		try {
			
			Query query=session.createQuery("from PolicyCoverage where pid= :pid and itemName= :itemName");
		    query.setParameter("pid", pid);
		    query.setParameter("itemName", itemName);
		    list=query.list();
		} finally {
			session.close();
		}
		return !(list.size()==0);
	}
}
