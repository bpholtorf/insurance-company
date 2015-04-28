package com.insurance.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.SurgeryDB;

@Repository
public class SurgeryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
     public void addSurgery(SurgeryDB surgery) {
		
    	 try {
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.save(surgery);
				session.getTransaction().commit();
				session.close();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
      }
     
     public void deleteSurgery(int id) {
 		Session session = this.sessionFactory.openSession();
 		Query query = session.createQuery("delete SurgeryDB where surgery_id = :id");
 		query.setParameter("id", id);
 		query.executeUpdate();
 		session.close();
 	}
     
     public void updateSurgery(SurgeryDB surgery)
	   {
    	 try {
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.update(surgery);
				session.getTransaction().commit();
				session.close();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
	   }

}
