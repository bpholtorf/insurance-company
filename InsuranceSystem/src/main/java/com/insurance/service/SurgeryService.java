package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.SurgeryDao;
import com.insurance.data.SurgeryDB;

@Service
public class SurgeryService {
	@Autowired
	private SurgeryDao surgeryDao;
	
	public void addSurgery(SurgeryDB surgery){
		surgeryDao.addSurgery(surgery);
	}
	
	public void deleteSurgery(int id){
		surgeryDao.deleteSurgery(id);
	}
	
	public void updateSurgery(SurgeryDB surgery){
		surgeryDao.updateSurgery(surgery);
	}
	
	public String findSurgery(int id){
		List<SurgeryDB> list=surgeryDao.findSurgery();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getSurgery_id()==id){
				return list.get(i).getSurgery_name();
			}
		}
		return null;
	}

}
