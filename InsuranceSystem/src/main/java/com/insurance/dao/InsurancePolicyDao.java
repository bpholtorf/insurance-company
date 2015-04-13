package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.InsurancePolicyDB;
import com.insurance.data.PolicyToCustomerDB;

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
	
	public void addInsurancePolicy(InsurancePolicyDB insurancePolicy){
		Session session = this.sessionFactory.openSession();
		Query query=session.createSQLQuery("insert into insurance_policy(planType, policyName, premiumPercent, policyNumber, payPeriod, pamount, hamount) value('"+
				                        insurancePolicy.getPlanType()+"','"+insurancePolicy.getPolicyName()+"','"+
		                                  insurancePolicy.getPremiumPercent()+"','"+insurancePolicy.getPolicyNumber()+"','"+insurancePolicy.getPayPeriod()+"','"+
				                        insurancePolicy.getPamount()+"','"+insurancePolicy.getHamount()+"')");
		query.executeUpdate();
		session.close();
	}
	
	public boolean deleteInsurancePolicy(Integer id){
		if(!checkForCustomer(id)){
			Session session = this.sessionFactory.openSession();
			Query query = session.createQuery("delete InsurancePolicyDB where id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
			session.close();
			return true;
		}
		return false;
	}
	
	public boolean checkForCustomer(Integer pid) {
		Session session = sessionFactory.openSession();

		List<PolicyToCustomerDB> list = new ArrayList<PolicyToCustomerDB>();
		try {
			String hqlString = "FROM PolicyToCustomerDB where pid=:pid";
			Query query = session.createQuery(hqlString);
			query.setInteger("pid", pid);
			list = query.list();
		} finally {
			session.close();
		}
		return list.size() > 0;
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
		
		public InsurancePolicyDB findByPolicyNumber(String policyNumber) {
			Session session = sessionFactory.openSession();
			
			List<InsurancePolicyDB> list=new ArrayList<InsurancePolicyDB>();
			try {
				String hqlString="FROM InsurancePolicyDB where policyNumber=:policyNumber";
				Query query=session.createQuery(hqlString);
				query.setString("policyNumber", policyNumber);
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
