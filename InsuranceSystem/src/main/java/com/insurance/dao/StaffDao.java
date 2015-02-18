package com.insurance.dao;

import java.util.ArrayList;
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
	
	public void updatePassword(StaffDB staff,String pass){
		Session session = this.sessionFactory.openSession();
		
		Query query = session.createQuery("update StaffDB set username='"+staff.getUsername()+"'"
	       		+ ", password='"+pass+"'"
	       				+ ",firstName='"+staff.getFirstName()+"'"
	       						+ ",lastName='"+staff.getLastName()+"' "
	       								+ ",SSN='"+staff.getSSN()+"' "
	       										+ ",address='"+staff.getAddress()+"'"
	       												+ ",phoneNumber='"+staff.getPhoneNumber()+"'"
	       														+ ",email='"+staff.getEmail()+"'"
	       																+ ",dateOfBirth='"+staff.getDateOfBirth()+ "' where id="+staff.getId());  
		
		 query.executeUpdate();
         session.close();
	}
	
	 public void updateStaff(StaffDB staffDB)
	   {
		   Session session = sessionFactory.openSession();
		   session.update(staffDB);
		   session.flush();
			
	   }
	 public List<StaffDB> findAll()
		{
			Session session=sessionFactory.openSession();
			List<StaffDB> list=new ArrayList<StaffDB>();
			try{
				list=session.createQuery("from StaffDB").list();	
				
				}finally{
					session.close();
				}
			return list;
		}
		
		public void deleteStaff(String username)
		{

			Session session = this.sessionFactory.openSession();
			Query query = session.createQuery("delete StaffDB where username = :username");
			query.setParameter("username", username);
			query.executeUpdate();
			session.close();
		}
		public StaffDB findByUsername(String username) {
			// TODO Auto-generated method stub
			System.out.println("$$$"+username);
			Session session = sessionFactory.openSession();
			
			List<StaffDB> list=new ArrayList<StaffDB>();
			try {
				String hqlString="FROM StaffDB where username=:username";
				Query query=session.createQuery(hqlString);
				query.setString("username", username);
				list = query.list();
			} finally {
				session.close();
			}
			return list.get(0);
		}
}
