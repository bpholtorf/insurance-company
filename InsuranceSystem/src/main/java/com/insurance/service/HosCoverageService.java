package com.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.HosCoverageDao;
import com.insurance.dao.PolicyCoverageDao;

@Service
public class HosCoverageService {
  @Autowired
  private HosCoverageDao hDao;
  @Autowired
  private PolicyCoverageDao policyCoverageDao;
  public boolean isCovered(int pid,String itemName)
  {
	  return policyCoverageDao.isCovered(pid, itemName);
  }
  public double getDuc(String policyType, String itemName, String operatorTitle)
  {
	  return hDao.getDuc(policyType, itemName, operatorTitle);
  }
}
