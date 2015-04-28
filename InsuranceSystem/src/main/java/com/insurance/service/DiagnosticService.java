package com.insurance.service;

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

}
