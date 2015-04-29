package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.PolicyCoverage;
import com.insurance.data.PolicyCoverageDB;
import com.insurance.data.PolicyToCustomerDB;


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
	
	
	@SuppressWarnings("unchecked")
	public List<PolicyCoverageDB> listPolicyCoverage(){
		Session session = sessionFactory.openSession();
		List<PolicyCoverageDB> list;
		try {
			list = session.createQuery("from PolicyCoverageDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void deletePolicyCoverage(int pid,String itemName){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete PolicyCoverageDB where pid = :pid AND itemName = :itemName");
		query.setParameter("pid", pid);
		query.setParameter("itemName", itemName);
		query.executeUpdate();
		session.close();
	}

	public void addPolicyCoverage(int pid, String itemName) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createSQLQuery("insert into policy_coverage(pid, itemName) value('" + pid + "','" + itemName + "')");
		query.executeUpdate();
		session.close();
		
	}
	
	public void deleteCoverage(String itemName){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete PolicyCoverageDB itemName = :itemName");
		query.setParameter("itemName", itemName);
		query.executeUpdate();
		session.close();
	}
}
