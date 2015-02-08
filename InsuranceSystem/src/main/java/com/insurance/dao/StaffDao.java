package com.insurance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.StaffDB;

@Repository
public class StaffDao {
 
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<StaffDB> listStaff(){
		Session session = sessionFactory.openSession();
		List<StaffDB> list;
		try {
			list = session.createQuery("from StaffDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void addStaff(StaffDB staff){
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(staff);
		transaction.commit();
		session.close();
	}
	
	public void deleteStaff(Integer id){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete StaffDB where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
	}
}
