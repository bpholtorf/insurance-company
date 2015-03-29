package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.InsurancePolicyDao;
import com.insurance.data.InsurancePolicyDB;
import com.insurance.data.StaffDB;

@Service
public class InsurancePolicyService {
	
	@Autowired
	private InsurancePolicyDao InsurancePolicyDao;
	

	
	
	public InsurancePolicyDB getInsurancePolicyById(Integer id){
		List<InsurancePolicyDB> list=InsurancePolicyDao.listInsurancePolicy();
		for (int i = 0; i < list.size(); i++) {
			InsurancePolicyDB insurancePolicy = list.get(i);
			if (insurancePolicy.getId().equals(id)) {
				return insurancePolicy;
			}
		}
		return null;
		
	}

	public List<InsurancePolicyDB> findAll()
	{
		return InsurancePolicyDao.findAll();
	}
	public void addInsurancePolicy(InsurancePolicyDB insurancePolicyDB)
	{
		InsurancePolicyDao.addInsurancePolicy(insurancePolicyDB);
	}
	public void deleteInsurancePolicy(Integer id)
	{
		InsurancePolicyDao.deleteInsurancePolicy(id);
	}

	public InsurancePolicyDB findById(Integer id) {
		return InsurancePolicyDao.findById(id);
	}

	public void updateInsurancePolicy(InsurancePolicyDB insurancePolicy) {
		// TODO Auto-generated method stub
		InsurancePolicyDao.updateInsurancePolicy(insurancePolicy);
	}
	
	public List<InsurancePolicyDB> checkPolicyID(String name) {
		return InsurancePolicyDao.checkPolicyID(name);
	}
	


	public List<InsurancePolicyDB> searchByNumber(String keyword) {
		return InsurancePolicyDao.searchByNumber(keyword);
	}

	public List<InsurancePolicyDB> searchByName(String pattern) {
		return InsurancePolicyDao.searchByName(pattern);
	}
}
