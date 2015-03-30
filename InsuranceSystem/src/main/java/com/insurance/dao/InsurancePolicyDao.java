package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.InsurancePolicyDB;
import com.insurance.data.StaffDB;

@Repository
public class InsurancePolicyDao {
 
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<InsurancePolicyDB> listInsurancePolicy(){
		Session session = sessionFactory.openSession();
		List<InsurancePolicyDB> list;
		try {
			list = session.createQuery("from InsurancePolicyDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void addInsurancePolicy(InsurancePolicyDB InsurancePolicy){
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(InsurancePolicy);
		transaction.commit();
		session.close();
	}
	
	public void deleteInsurancePolicy(Integer id){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete InsurancePolicyDB where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
	}
	
	 public void updateInsurancePolicy(InsurancePolicyDB InsurancePolicyDB)
	   {
		   Session session = sessionFactory.openSession();
		   session.update(InsurancePolicyDB);
		   session.flush();
			
	   }
	 
	 public List<InsurancePolicyDB> findAll()
		{
			Session session=sessionFactory.openSession();
			List<InsurancePolicyDB> list=new ArrayList<InsurancePolicyDB>();
			try{
				list=session.createQuery("from InsurancePolicyDB").list();	
				
				}finally{
					session.close();
				}
			return list;
		}
		
		public InsurancePolicyDB findById(Integer id) {
			// TODO Auto-generated method stub
			System.out.println("$$$"+id);
			Session session = sessionFactory.openSession();
			
			List<InsurancePolicyDB> list=new ArrayList<InsurancePolicyDB>();
			try {
				String hqlString="FROM InsurancePolicyDB where id=:id";
				Query query=session.createQuery(hqlString);
				query.setInteger("id", id);
				list = query.list();
			} finally {
				session.close();
			}
			return list.get(0);
		}
		
		public List<InsurancePolicyDB> searchByNumber(String keyword) {
			Session session = sessionFactory.openSession();

			List<InsurancePolicyDB> list = new ArrayList<InsurancePolicyDB>();
			try {
				String hqlString = "FROM InsurancePolicyDB where policyNumber= :policyNumber";
				Query query = session.createQuery(hqlString);
				query.setString("policyNumber", keyword);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}

		public List<InsurancePolicyDB> searchByName(String pattern) {
			Session session = sessionFactory.openSession();

			List<InsurancePolicyDB> list = new ArrayList<InsurancePolicyDB>();
			try {
				String hqlString = "FROM InsurancePolicyDB where policyName like :policyName";
				Query query = session.createQuery(hqlString);
				query.setString("policyName", pattern);
				list = query.list();
				return list;
			} finally {
				session.close();
			}
		}
}
