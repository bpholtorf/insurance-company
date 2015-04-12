package com.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.dao.DrugCoverageDao;

@Service
public class DrugCoverageService {
  @Autowired
  private DrugCoverageDao cDao;
  
  public boolean isCovered(String drugId)
  {
	  return cDao.isCovered(drugId);
  }
}
