package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.TreatmentDao;
import com.insurance.data.TreatmentDB;

@Service
public class TreatmentService {
	@Autowired
	private TreatmentDao treatmentDao;
	
	public void addTreatment(TreatmentDB treatment){
		treatmentDao.addTreatment(treatment);
	}
	
	public void deleteTreatment(int id){
		treatmentDao.deleteTreatment(id);
	}
	
	public void updateTreatment(TreatmentDB treatment){
		treatmentDao.updateTreatment(treatment);
	}
	
	public String findTreatment(int id){
		List<TreatmentDB> list=treatmentDao.findTreatment();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTreatment_id()==id){
				return list.get(i).getTreatment_name();
			}
		}
		return null;
	}

}
