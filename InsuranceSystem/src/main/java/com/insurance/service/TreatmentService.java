package com.insurance.service;

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

}
