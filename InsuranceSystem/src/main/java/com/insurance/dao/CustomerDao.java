package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.CustomerDB;

@Repository
public class CustomerDao {
 
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<CustomerDB> listCustomer(){
		Session session = sessionFactory.openSession();
		List<CustomerDB> list;
		try {
			list = session.createQuery("from CustomerDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void addCustomer(CustomerDB Customer){
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(Customer);
		transaction.commit();
		session.close();
	}
	
	public void deleteCustomer(Integer id){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete CustomerDB where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
	}
	
	public void updatePassword(CustomerDB Customer,String pass){
		Session session = this.sessionFactory.openSession();
		
		Query query = session.createQuery("update CustomerDB set firstName='"+Customer.getFirstName()+"'"
				+ ",lastName='"+Customer.getLastName()+"' "
						+ ",address='"+Customer.getAddress()+"'"
								+ ",phoneNumber='"+Customer.getPhoneNumber()+"'"
										+ ",email='"+Customer.getEmail()+"'"
												+ ",incomeStatus='"+Customer.getIncomeStatus()+"'"
														+ ",sponsorInfo='"+Customer.getSponsorInfo()+"'"
																		+ ",employerInfo='"+Customer.getEmployerInfo()+ "' where id="+Customer.getId());  
		
		 query.executeUpdate();
         session.close();
	}
	
	 public void updateCustomer(CustomerDB CustomerDB)
	   {
		   Session session = sessionFactory.openSession();
		   session.update(CustomerDB);
		   session.flush();
			
	   }
	 public List<CustomerDB> findAll()
		{
			Session session=sessionFactory.openSession();
			List<CustomerDB> list=new ArrayList<CustomerDB>();
			try{
				list=session.createQuery("from CustomerDB").list();	
				
				}finally{
					session.close();
				}
			return list;
		}
		
		public CustomerDB findById(Integer id) {
			// TODO Auto-generated method stub
			System.out.println("$$$"+id);
			Session session = sessionFactory.openSession();
			
			List<CustomerDB> list=new ArrayList<CustomerDB>();
			try {
				String hqlString="FROM CustomerDB where id=:id";
				Query query=session.createQuery(hqlString);
				query.setInteger("id", id);
				list = query.list();
			} finally {
				session.close();
			}
			return list.get(0);
		}
}