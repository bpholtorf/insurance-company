package com.insurance.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.EmployeeDB;
@Repository
public class EmployeeDao {
 
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<EmployeeDB> listEmployee(){
		Session session = sessionFactory.openSession();
		List<EmployeeDB> list;
		try {
			list = session.createQuery("from EmployeeDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void addEmployee(EmployeeDB customer) {
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
	
	
	

	
	 public List<EmployeeDB> findAll()
		{
			Session session=sessionFactory.openSession();
			List<EmployeeDB> list=new ArrayList<EmployeeDB>();
			try{
				list=session.createQuery("from EmployeeDB").list();	
				
				}finally{
					session.close();
				}
			return list;
		}
		
		public EmployeeDB findById(Integer id) {
			// TODO Auto-generated method stub
			System.out.println("$$$"+id);
			Session session = sessionFactory.openSession();
			
			List<EmployeeDB> list=new ArrayList<EmployeeDB>();
			try {
				String hqlString="FROM EmployeeDB where id=:id";
				Query query=session.createQuery(hqlString);
				query.setInteger("id", id);
				list = query.list();
			} finally {
				session.close();
			}
			return list.get(0);
		}
		

		public List<EmployeeDB> searchBySSN(String keyword) {
			Session session = sessionFactory.openSession();

			List<EmployeeDB> list = new ArrayList<EmployeeDB>();
			try {
				String hqlString = "FROM EmployeeDB where SSN like :SSN";
				Query query = session.createQuery(hqlString);
				query.setString("SSN", keyword);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}
		



		public List<EmployeeDB> searchByName(String pattern) {
			Session session = sessionFactory.openSession();

			List<EmployeeDB> list = new ArrayList<EmployeeDB>();
			try {
				String hqlString = "FROM EmployeeDB where lastName like :name or firstName like :name";
				Query query = session.createQuery(hqlString);
				query.setString("name", pattern);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}

		public List<EmployeeDB> searchByDateofBirth(String keyword) throws ParseException  {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			
			List<EmployeeDB> list = new ArrayList<EmployeeDB>();
			try {
				String hqlString = "FROM EmployeeDB where dateofBirth=:DateofBirth";
				Query query = session.createQuery(hqlString);
				query.setString("DateofBirth", keyword);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}

		
}
