package com.insurance.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.StaffDB;
import com.insurance.data.StaffDB2;

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
	
	public void addStaff(StaffDB staff) {
		Session session = this.sessionFactory.openSession();
		SimpleDateFormat dt=new SimpleDateFormat("yyyy-mm-dd");
		String date=dt.format(staff.getDateOfBirth());
		Query query=session.createSQLQuery("insert into Staff(username,password,firstName,lastName,SSN,address,phoneNumber,email,gender,dateOfBirth) value('"+
		                                  staff.getUsername()+"','"+staff.getPassword()+"','"+
				                        staff.getFirstName()+"','"+staff.getLastName()+"','"+
		                                  staff.getSSN()+"','"+staff.getAddress()+"','"+staff.getPhoneNumber()+"','"+
				                        staff.getEmail()+"','"+staff.getGender()+"','"+date+"')");
		query.executeUpdate();
		

		session.close();
	}
	public void deleteStaff(Integer id){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("update StaffDB set able=: able where id = :id");
		query.setParameter("able", 0);
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
				list=session.createQuery("from StaffDB where able=1").list();	
				
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
		
		public boolean checkUsername(String username) {
			Session session = sessionFactory.openSession();

			List<StaffDB> list = new ArrayList<StaffDB>();
			try {
				String hqlString = "FROM StaffDB where username=:username";
				Query query = session.createQuery(hqlString);
				query.setString("username", username);
				list = query.list();
				if (list.size() == 0) {
					System.out.println("&" + username);
					return true;

				} else {
					return false;
				}
			} finally {
				session.close();
			}

		}
		
		public void updateStaff(StaffDB2 staff) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.openSession();
			SimpleDateFormat dt=new SimpleDateFormat("yyyy-mm-dd");
			String date=dt.format(staff.getDateOfBirth());
			Query query = session.createQuery("update StaffDB2 set username='"+staff.getUsername()+"'"
		       		+ ", password='"+staff.getPassword()+"'"
		       				+ ",firstName='"+staff.getFirstName()+"'"
		       						+ ",lastName='"+staff.getLastName()+"' "
		       								+ ",SSN='"+staff.getSSN()+"' "
		       										+ ",address='"+staff.getAddress()+"'"
		       												+ ",phoneNumber='"+staff.getPhoneNumber()+"'"
		       														+ ",email='"+staff.getEmail()+"'"
		       																+ ",dateOfBirth='"+date+ "' where id="+staff.getId());  
			
			 query.executeUpdate();
	         session.close();
		}

		public List<StaffDB> searchBySSN(String keyword) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();

			List<StaffDB> list = new ArrayList<StaffDB>();
			try {
				String hqlString = "FROM StaffDB where SSN=:SSN";
				Query query = session.createQuery(hqlString);
				query.setString("SSN", keyword);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}

		public List<StaffDB> searchByName(String pattern) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();

			List<StaffDB> list = new ArrayList<StaffDB>();
			try {
				String hqlString = "FROM StaffDB where name like :name";
				Query query = session.createQuery(hqlString);
				query.setString("name", pattern);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}

		public List<StaffDB> searchByUsername(String pattern) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();

			List<StaffDB> list = new ArrayList<StaffDB>();
			try {
				String hqlString = "FROM StaffDB where username like :name";
				Query query = session.createQuery(hqlString);
				query.setString("name", pattern);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}
}
