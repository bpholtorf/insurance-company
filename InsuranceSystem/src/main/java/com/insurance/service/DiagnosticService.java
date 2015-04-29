package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.DiagnosticDao;
import com.insurance.data.DiagnosticDB;

@Service
public class DiagnosticService {
	@Autowired
	private DiagnosticDao diagnosticDao;
	
	public void addDiagnostic(DiagnosticDB diagnostic){
		diagnosticDao.addDiagnostic(diagnostic);
	}
	
	public void deleteDiagnostic(int id){
		diagnosticDao.deleteDiagnostic(id);
	}
	
	public void updateDiagnostic(DiagnosticDB diagnostic){
		diagnosticDao.updateDiagnostic(diagnostic);
	}
	
	public String findDiagnostic(int id){
		List<DiagnosticDB> list=diagnosticDao.findDiagnostic();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getDiagnostic_test_id()==id){
				return list.get(i).getDiagnostic_test_name();
			}
		}
		return null;
	}

}
