package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.BillInfoDao;
import com.insurance.dao.HosBillInfoDao;
import com.insurance.data.BillInfoDB;
import com.insurance.data.HosBillInfoDB;
@Service
public class BillInfoService {
  @Autowired
  private BillInfoDao billInfoDao;
  @Autowired
  private HosBillInfoDao hInfoDao;
  public List<BillInfoDB> findBillInfoByBillNum(String n)
  {
	  return billInfoDao.findBillInfoBillNum(n);
  }
  public void update(BillInfoDB b)
  {
	  billInfoDao.update(b);
	  
  }
  public void updateHosBillInfo(HosBillInfoDB hDb)
  {
	  hInfoDao.update(hDb);
  }
}
