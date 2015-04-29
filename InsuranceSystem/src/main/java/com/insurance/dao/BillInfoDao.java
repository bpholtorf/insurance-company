package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.BillInfoDB;

@Repository
public class BillInfoDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<BillInfoDB> findBillBySSN(int ssn, int status)
	{
		Session session = sessionFactory.openSession();
		List<BillInfoDB> list=new ArrayList<BillInfoDB>();
		try {
			String hqlString="from BillInfoDB where ssn=:ssn and status=:status";
			Query query=session.createQuery(hqlString);
			if (status==0) {				
				query.setInteger("ssn", ssn);
				query.setInteger("status", status);
			}
			list=query.list();
		} finally {
			session.close();
		}
		return list;
	}
}
