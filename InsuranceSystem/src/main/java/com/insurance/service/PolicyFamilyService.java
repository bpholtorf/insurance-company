package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.PolicyFamilyDao;
import com.insurance.data.PolicyFamilyDB;

@Service
public class PolicyFamilyService {

	@Autowired
	private PolicyFamilyDao pfDao;
	
	public List<PolicyFamilyDB> getAllMembers(){
		return pfDao.listMembers();
	}
	
	public void addMember(PolicyFamilyDB pf){
		pfDao.addMember(pf);
	}
}
