package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.BillInfoDao;
import com.insurance.data.BillInfoDB;

@Service
public class BillInfoService {
	@Autowired
  private BillInfoDao bDao;
  public List<BillInfoDB> findBillBySSN(int ssn,int status)
  {
	  return bDao.findBillBySSN(ssn, status);
  }
}
