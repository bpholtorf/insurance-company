package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.HosBillInfoDB;

@Repository
public class HosBillInfoDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public List<HosBillInfoDB> findBillInfoBillNum(String number)
	{
		Session session = sessionFactory.openSession();
		List<HosBillInfoDB> list=new ArrayList<HosBillInfoDB>();
		try {
			String hqlString="from HosBillInfoDB where billNumber=:billNumber";
			Query query=session.createQuery(hqlString);
			query.setString("billNumber", number);
			list=query.list();
		} finally {
			session.close();
		}
		return list;
	}
	public void update(HosBillInfoDB hDb)
	{
		Session session = sessionFactory.openSession();
		   session.update(hDb);
		   session.flush();
		   session.close();
	}
}
