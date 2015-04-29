package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.DiagnosticDB;
import com.insurance.data.StaffDB;




@Repository
public class DiagnosticDao {

	@Autowired
	private SessionFactory sessionFactory;
	
     public void addDiagnostic(DiagnosticDB diagnostic) {
		
    	 try {
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.save(diagnostic);
				session.getTransaction().commit();
				session.close();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
      }
     
     public void deleteDiagnostic(int id) {
 		Session session = this.sessionFactory.openSession();
 		Query query = session.createQuery("delete DiagnosticDB where diagnostic_test_id = :id");
 		query.setParameter("id", id);
 		query.executeUpdate();
 		session.close();
 	}
     
     public void updateDiagnostic(DiagnosticDB diagnosticDB)
	   {
    	 try {
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.update(diagnosticDB);
				session.getTransaction().commit();
				session.close();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
	   }
     
     public List<DiagnosticDB> findDiagnostic(){
    	 Session session = sessionFactory.openSession();
 		List<DiagnosticDB> list;
 		try {
 			list = session.createQuery("from DiagnosticDB").list();
 		} finally {
 			session.close();
 		}
 		return list;
     }

}
