package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.BillHeaderDB;
import com.insurance.data.BillInfoDB;

@Repository
public class BillDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<BillHeaderDB> getBills(int ssn,int status)
	{
		Session session = sessionFactory.openSession();
		List<BillHeaderDB> list=new ArrayList<BillHeaderDB>();
		try {
			String hqlString="from BillHeaderDB where ssn=:ssn and status=:status";
			Query query=session.createQuery(hqlString);
							
				query.setParameter("ssn", ssn);
				query.setParameter("status", status);
			
			list=query.list();
		} finally {
			session.close();
		}
		return list;
	}
	public BillHeaderDB getBillByBillNumber(String billNumber)
	{
		Session session = sessionFactory.openSession();
		List<BillHeaderDB> list=new ArrayList<BillHeaderDB>();
		try {
			String hqlString="from BillHeaderDB where billNumber=:billNumber";
			Query query=session.createQuery(hqlString);							
			query.setParameter("billNumber",billNumber);							
			list=query.list();
		} finally {
			session.close();
		}
		return list.get(0);
	}

	public void update(BillHeaderDB db) {
		Session session = sessionFactory.openSession();
		   session.update(db);
		   session.flush();
		   session.close();
		
	}

	public List<BillHeaderDB> getBills(int i,String billType) {
		
		Session session = sessionFactory.openSession();
		List<BillHeaderDB> list=new ArrayList<BillHeaderDB>();
		try {
			String hqlString="from BillHeaderDB where billType=:billType and status=:status";
			Query query=session.createQuery(hqlString);	
			query.setString("billType", billType);
			query.setInteger("status", i);		
			
			list=query.list();
		} finally {
			session.close();
		}
		return list;
	}

	

	
}
