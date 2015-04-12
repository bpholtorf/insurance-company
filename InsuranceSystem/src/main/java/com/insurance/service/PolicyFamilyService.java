package com.insurance.service;

import java.util.ArrayList;
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
	
	public List<PolicyFamilyDB> getMembersForOne(int cid,int pid){
		List<PolicyFamilyDB> list=pfDao.listMembers();
		List<PolicyFamilyDB> list1=new ArrayList<PolicyFamilyDB>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getCid()==cid && list.get(i).getPid()==pid){
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	
	public void deleteMembers(int cid,int pid){
		pfDao.deleteMembers(cid, pid);
	}
}
