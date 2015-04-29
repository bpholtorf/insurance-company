package com.insurance.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.SurgeryDB;
import com.insurance.data.TreatmentDB;

@Repository
public class TreatmentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
     public void addTreatment(TreatmentDB treatment) {
		
    	 try {
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.save(treatment);
				session.getTransaction().commit();
				session.close();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
      }
     
     public void deleteTreatment(int id) {
 		Session session = this.sessionFactory.openSession();
 		Query query = session.createQuery("delete TreatmentDB where surgery_id = :id");
 		query.setParameter("id", id);
 		query.executeUpdate();
 		session.close();
 	}
     
     public void updateTreatment(TreatmentDB treatment)
	   {
    	 try {
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.update(treatment);
				session.getTransaction().commit();
				session.close();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
	   }
     
     public List<TreatmentDB> findTreatment(){
    	 Session session = sessionFactory.openSession();
 		List<TreatmentDB> list;
 		try {
 			list = session.createQuery("from TreatmentDB").list();
 		} finally {
 			session.close();
 		}
 		return list;
     }

}
