package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.DrugCoverageDao;
import com.insurance.data.DrugCoverageDB;

@Service
public class DrugCoverageService {
  @Autowired
  private DrugCoverageDao cDao;
  
  public boolean isCovered(String drugId)
  {
	  return cDao.isCovered(drugId);
  }
  public List<DrugCoverageDB> findAll()
  {
	  return cDao.findAll();
  }
public void save(DrugCoverageDB drugCoverageDB) {
	cDao.save(drugCoverageDB);
	
}
public void delete(String drugId) {
	cDao.delete(drugId);
	
}
}
