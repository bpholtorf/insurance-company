package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	
	public void deleteMembers(int cid,int pid){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete PolicyFamilyDB where cid = :cid AND pid= :pid");
		query.setParameter("pid", pid);
		query.setParameter("cid", cid);
		query.executeUpdate();
		session.close();
	}

	public String getMemberSSN(String memberName,int pid,int cid) {
		Session session = sessionFactory.openSession();
		List<PolicyFamilyDB> list=new ArrayList<PolicyFamilyDB>();
		try {
			Query query = session.createQuery("from PolicyFamilyDB where pid = :pid AND cid= :cid and memberName= :memberName");
			query.setParameter("pid", pid);
			query.setParameter("cid", cid);
			query.setParameter("memberName", memberName);
			list=query.list();
		} finally {
			session.close();
		}
		if (list.size()>0) {
			return list.get(0).getMemberSSN();
		}
		else {
			return null;
		}
		
	}

	public PolicyFamilyDB getCidBySSN(String ssn) {
		Session session = sessionFactory.openSession();
		List<PolicyFamilyDB> list=new ArrayList<PolicyFamilyDB>();
		try {
			Query query = session.createQuery("from PolicyFamilyDB where memberSSN= :memberSSN and memberName= :memberName");
			query.setParameter("memberSSN", ssn);
		
			list=query.list();
		} finally {
			session.close();
		}
		
			return list.get(0);
		
		
	}
	

	

}
