package com.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.HospitalCoverageDao;
import com.insurance.data.HospitalCoverageDB;

@Service
public class HospitalCoverageService {
	@Autowired
	private HospitalCoverageDao pcDao;
	
	public List<HospitalCoverageDB> getAll(){
		return pcDao.listHospitalCoverage();
	}
	
	public List<HospitalCoverageDB> getOneAll(String itemName){
		List<HospitalCoverageDB> list=pcDao.listHospitalCoverage();
		List<HospitalCoverageDB> list1=new ArrayList<HospitalCoverageDB>();
		for(int i=0;i<list.size();i++){
			HospitalCoverageDB pc=list.get(i);
			if(pc.getItemName().equals(itemName)){
				list1.add(pc);
			}
			
		}
		return list1;
	}
	
	public List<HospitalCoverageDB> getAllByPlanType(String planType){
		List<HospitalCoverageDB> listAll=pcDao.listHospitalCoverage();
		List<HospitalCoverageDB> listPlanType=new ArrayList<HospitalCoverageDB>();
		for(int i=0;i<listAll.size();i++){
			HospitalCoverageDB pc=listAll.get(i);
			if(pc.getPolicyType().equals(planType)){
				listPlanType.add(pc);
			}
			
		}
		return listPlanType;
	}

}
