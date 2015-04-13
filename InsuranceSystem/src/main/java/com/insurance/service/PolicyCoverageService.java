package com.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.PolicyCoverageDao;
import com.insurance.data.PolicyCoverageDB;
import com.insurance.data.PolicyToCustomerDB;

@Service
public class PolicyCoverageService {
	@Autowired
	private PolicyCoverageDao pcDao;
	
	
	public Boolean checkAdded(int pid, String itemName){
		List<PolicyCoverageDB> list=pcDao.listPolicyCoverage();
		for(int i=0;i<list.size();i++){
			PolicyCoverageDB pc=list.get(i);
			if(pc.getItemName().equals(itemName) && pc.getPid()==pid){
				return true;
			}
		}
		return false;
	}
	
	public List<PolicyCoverageDB> getAll(){
		return pcDao.listPolicyCoverage();
	}
	
	public List<PolicyCoverageDB> getOneAll(String itemName){
		List<PolicyCoverageDB> list=pcDao.listPolicyCoverage();
		List<PolicyCoverageDB> list1=new ArrayList<PolicyCoverageDB>();
		for(int i=0;i<list.size();i++){
			PolicyCoverageDB pc=list.get(i);
			if(pc.getItemName().equals(itemName)){
				list1.add(pc);
			}
			
		}
		return list1;
	}
	
	public void deletePolicyCoverage(int pid,String itemName){
		pcDao.deletePolicyCoverage(pid, itemName);
	}
	
	public void addPolicyCoverage(int pid, String itemName) {
		pcDao.addPolicyCoverage(pid, itemName);
		
	}

}
