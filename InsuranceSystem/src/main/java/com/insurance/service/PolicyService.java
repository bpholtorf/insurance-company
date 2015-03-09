package com.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.data.PolicyDB;
import com.insurance.dao.PolicyDao;

@Service
public class PolicyService {
	
	@Autowired
	private PolicyDao policyDao;
	
	public List<PolicyDB> getPolicy(){
		List<PolicyDB> list=policyDao.listPolicys();
		for(int i=0;i<list.size()-1;i++){
			for(int j=list.size()-1;j>i;j--){
				if(list.get(j).getPolicyName().equals(list.get(i).getPolicyName()))
					list.remove(j);
			}
		}
		return list;
	}
	
	public List<PolicyDB> getPolicyByName(String name){
		List<PolicyDB> list=policyDao.listPolicys();
		List<PolicyDB> list1=new ArrayList<PolicyDB>();
		for (int i = 0; i < list.size(); i++) {
			PolicyDB po=list.get(i);
			if(po.getPolicyName().equals(name)){
				list1.add(po);
				
			}
		}
		return list1;
	}
	
	public PolicyDB getPolicyById(int id){
		List<PolicyDB> list=policyDao.listPolicys();
	    for(int i=0;i<list.size();i++){
	    	PolicyDB po=list.get(i);
	    	if(po.getId()==id){
	    		return po;
	    	}
	    }
	    return null;
	}

}
