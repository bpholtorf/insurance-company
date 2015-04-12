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
	
	public void deletePolicyToCustomer(int pid,int cid){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete PolicyToCustomerDB where pid = :pid AND cid= :cid");
		query.setParameter("pid", pid);
		query.setParameter("cid", cid);
		query.executeUpdate();
		session.close();
	}
public PolicyToCustomerDB getById(int pid, int cid) {
		
		Session session=this.sessionFactory.openSession();
		List<PolicyToCustomerDB> list;
		try{
		Query query=session.createQuery("from PolicyToCustomerDB where pid= :pid and cid= :cid");
		query.setParameter("pid", pid);
		query.setParameter("cid", cid);
		list=query.list();
		}
		finally{
			session.close();
		}
	    return list.get(0);
		
				
	}

public void updateAmountLeft(PolicyToCustomerDB pDb) {
	  Session session = sessionFactory.openSession();
	   session.update(pDb);
	   session.flush();
	   session.close();
	   
	
}

}
