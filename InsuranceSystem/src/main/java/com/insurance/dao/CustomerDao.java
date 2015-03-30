package com.insurance.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.CustomerDB;
import com.insurance.data.PolicyToCustomerDB;

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
	
	public void addCustomer(CustomerDB customer) {
		Session session = this.sessionFactory.openSession();
		SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
		String date=dt.format(customer.getDateOfBirth());
		Query query=session.createSQLQuery("insert into Customer(firstName,lastName,SSN,address,phoneNumber,email,gender,dateOfBirth,incomeStatus, employerInfo, sponsorInfo) value('"+
				                        customer.getFirstName()+"','"+customer.getLastName()+"','"+
		                                  customer.getSSN()+"','"+customer.getAddress()+"','"+customer.getPhoneNumber()+"','"+
				                        customer.getEmail()+"','"+customer.getGender()+"','"+date+"','"+customer.getIncomeStatus()+
				                        customer.getEmployerInfo()+"','"+ customer.getSponsorInfo()+"','"+"')");
		query.executeUpdate();
		session.close();
	}
	
	public boolean deleteCustomer(Integer id){
		if(!checkForPolicy(id)){
			Session session = this.sessionFactory.openSession();
			Query query = session.createQuery("delete CustomerDB where id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
			session.close();
			return true;
		}
		return false;
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
		

		public List<CustomerDB> searchBySSN(String keyword) {
			Session session = sessionFactory.openSession();

			List<CustomerDB> list = new ArrayList<CustomerDB>();
			try {
				String hqlString = "FROM CustomerDB where SSN=:SSN";
				Query query = session.createQuery(hqlString);
				query.setString("SSN", keyword);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}
		

		public boolean checkForPolicy(Integer cid) {
			Session session = sessionFactory.openSession();

			List<PolicyToCustomerDB> list = new ArrayList<PolicyToCustomerDB>();
			try {
				String hqlString = "FROM PolicyToCustomerDB where cid=:cid";
				Query query = session.createQuery(hqlString);
				query.setInteger("cid", cid);
				list = query.list();
			} finally {
				session.close();
			}
			return list.size() > 0;
		}

		public List<CustomerDB> searchByName(String pattern) {
			Session session = sessionFactory.openSession();

			List<CustomerDB> list = new ArrayList<CustomerDB>();
			try {
				String hqlString = "FROM CustomerDB where lastName like :name or firstName like :name";
				Query query = session.createQuery(hqlString);
				query.setString("name", pattern);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}

		public List<CustomerDB> searchByDateofBirth(String keyword) throws ParseException  {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			
			List<CustomerDB> list = new ArrayList<CustomerDB>();
			try {
				String hqlString = "FROM CustomerDB where dateofBirth=:DateofBirth";
				Query query = session.createQuery(hqlString);
				query.setString("DateofBirth", keyword);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}
}
