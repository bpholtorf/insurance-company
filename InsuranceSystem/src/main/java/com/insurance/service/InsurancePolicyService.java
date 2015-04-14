package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.InsurancePolicyDao;
import com.insurance.data.CustomerDB;
import com.insurance.data.InsurancePolicyDB;
import com.insurance.data.InsurancePolicyDB2;
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
	public String addInsurancePolicy(InsurancePolicyDB insurancePolicyDB)
	{
		return InsurancePolicyDao.addInsurancePolicy(insurancePolicyDB);
	}
	public boolean deleteInsurancePolicy(Integer id)
	{
		return InsurancePolicyDao.deleteInsurancePolicy(id);
	}

	public InsurancePolicyDB findById(Integer id) {
		return InsurancePolicyDao.findById(id);
	}

	public void updateInsurancePolicy(InsurancePolicyDB2 insurancePolicy) {
		// TODO Auto-generated method stub
		InsurancePolicyDao.updateInsurancePolicy(insurancePolicy);
	}
	


	public List<InsurancePolicyDB> searchByNumber(String keyword) {
		return InsurancePolicyDao.searchByNumber(keyword);
	}

	public List<InsurancePolicyDB> searchByName(String pattern) {
		return InsurancePolicyDao.searchByName(pattern);
	}

	public InsurancePolicyDB findByPolicyNumber(String policyNumber) {
		return InsurancePolicyDao.findByPolicyNumber(policyNumber);
	}
}
