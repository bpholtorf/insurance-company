package com.insurance.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.insurance.data.HospitalCoverageDB;

@Repository
public class HospitalCoverageDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<HospitalCoverageDB> listHospitalCoverage(){
		Session session = sessionFactory.openSession();
		List<HospitalCoverageDB> list;
		try {
			list = session.createQuery("from HospitalCoverageDB").list();
		} finally {
			session.close();
		}
		return list;
	}
	

}
