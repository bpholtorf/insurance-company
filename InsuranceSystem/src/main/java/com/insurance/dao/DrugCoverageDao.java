package com.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.data.DrugCoverageDB;



@Repository
public class DrugCoverageDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	public boolean isCovered(String drugId)
	{
		Session session = sessionFactory.openSession();
		List<DrugCoverageDB> list=new ArrayList<DrugCoverageDB>();
		try {
			
			Query query=session.createQuery("from DrugCoverageDB where drugId= :drugId");
		    query.setString("drugId",drugId );
		    
		    list=query.list();
		} finally {
			session.close();
		}
		return !(list.size()==0);
	}

}
