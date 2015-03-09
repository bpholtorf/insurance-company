package com.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.PolicyToCustomerDao;
import com.insurance.data.PolicyToCustomerDB;

@Service
public class PolicyToCustomerService {
	@Autowired
	private PolicyToCustomerDao pcDao;
	
	public void addPolicyToCustomer(PolicyToCustomerDB pcDB){
		pcDao.addPolicyToCustomer(pcDB);
	}
	
	public Boolean checkAdded(int cid,int pid){
		List<PolicyToCustomerDB> list=pcDao.listPolicyToCustomer();
		for(int i=0;i<list.size();i++){
			PolicyToCustomerDB pc=list.get(i);
			if(pc.getCid()==cid && pc.getPid()==pid){
				return true;
			}
		}
		return false;
	}
	
	public List<PolicyToCustomerDB> getAll(){
		return pcDao.listPolicyToCustomer();
	}
	
	public List<PolicyToCustomerDB> getOneAll(int cid){
		List<PolicyToCustomerDB> list=pcDao.listPolicyToCustomer();
		List<PolicyToCustomerDB> list1=new ArrayList<PolicyToCustomerDB>();
		for(int i=0;i<list.size();i++){
			PolicyToCustomerDB pc=list.get(i);
			if(pc.getCid()==cid){
				list1.add(pc);
			}
			
		}
		return list1;
	}

}
