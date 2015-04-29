package com.insurance.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javassist.expr.NewArray;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.BillDao;
import com.insurance.dao.BillInfoDao;
import com.insurance.dao.HosBillInfoDao;
import com.insurance.data.BillHeaderDB;
import com.insurance.data.HosBillDB;
import com.insurance.data.HosBillInfoDB;
import com.insurance.data.PharBillDB;
import com.insurance.data.BillInfoDB;

@Service
public class BillService {
	@Autowired
  private BillInfoDao bInfoDao;
	@Autowired
	private HosBillInfoDao hInfoDao;
	@Autowired
	private BillDao billDao;
	
  public List<PharBillDB> findPharBillBySSN(String ssn,int status)
  {
	  List<BillHeaderDB> billDBs=billDao.getBills(ssn, status);
	  List<PharBillDB> billDB2s=new ArrayList<PharBillDB>();
	  for(int i=0;i<billDBs.size();i++)
	  {
		    
			if (!billDBs.get(i).getBillType().equals(BillType.pharmacy.toString())) {
				billDBs.remove(i);
				--i;
			}
		  }
	  for (BillHeaderDB b:billDBs) {
		billDB2s.add(new PharBillDB(b.getBillNumber(), 
				                    b.getClaimNumber(), 
				                    b.getDate(), 
				                    b.getSsn(), 
				                    b.getStatus(),
				                    b.getTotalCharge(),
				                    b.getCustomerPay(),				                    
				                    b.getBillType(),
				                    b.getTotalCoverage()));
	}
	  for (PharBillDB b:billDB2s) {
		List<BillInfoDB> bInfoDBs=bInfoDao.findBillInfoBillNum(b.getBillNumber());
		b.setInfoDBs(bInfoDBs);
	}
	 
	  return billDB2s;
  }
  public List<HosBillDB> findHosBillBySSN(String ssn,int status)
  {
	  List<BillHeaderDB> billDBs=billDao.getBills(ssn, status);
	  List<HosBillDB> billDB2s=new ArrayList<HosBillDB>();	 	  
	  for(int i=0;i<billDBs.size();i++)
	  {
		    
			if (!billDBs.get(i).getBillType().equals(BillType.hospital.toString())) {
				billDBs.remove(i);
				--i;
			}
		  }
	  for (BillHeaderDB b:billDBs) {
		billDB2s.add(new HosBillDB(b.getBillNumber(), 
				b.getClaimNumber(), 
				b.getDate(), 
				b.getSsn(), 
				b.getStatus(),
				b.getTotalCharge(),
				b.getCustomerPay(),
				b.getBillType(),
				b.getTotalCoverage()));
	}
	  for (HosBillDB b:billDB2s) {
		List<HosBillInfoDB> bInfoDBs=hInfoDao.findBillInfoBillNum(b.getBillNumber());
		b.setInfoDBs(bInfoDBs);
	}
	 
	  return billDB2s;
  }
  public PharBillDB findBillByBillNum(String billNumber)
  {
	  BillHeaderDB b=billDao.getBillByBillNumber(billNumber);
	  if (b!=null) {
		
	
	  PharBillDB billDB2=new PharBillDB(b.getBillNumber(), 
			                      b.getClaimNumber(),
			                      b.getDate(), 
			                      b.getSsn(), 
			                      b.getStatus(),
			                      bInfoDao.findBillInfoBillNum(billNumber),			                    
			                      b.getTotalCharge(),
			                      b.getCustomerPay(),
			                      b.getBillType(),
			                      b.getTotalCoverage());
	  return billDB2;
	  }
	  else {
		return null;
	}
  }
  public HosBillDB getHosBill(String billNumber)
  {
	  BillHeaderDB b=billDao.getBillByBillNumber(billNumber);
	  if(b!=null)
	  {
	  HosBillDB bill=new HosBillDB(b.getBillNumber(), 
			                       b.getClaimNumber(), 
			                       b.getDate(), 
			                       b.getSsn(), 
			                       b.getStatus(), 
			                       hInfoDao.findBillInfoBillNum(billNumber), 
			                       b.getTotalCharge(), 
			                       b.getCustomerPay(), 
			                       b.getBillType(), 
			                       b.getTotalCoverage());
	  
	return bill;
	  }
	  else
		  return null;
	  
  }
  public void update(BillHeaderDB db)
  {
	  billDao.update(db);
  }
  public BillHeaderDB findBillDB(String billNumber)
  {
	  return billDao.getBillByBillNumber(billNumber);
  }
  public enum BillType{
		hospital, pharmacy
	}
   public List<PharBillDB> findAllPharBills() {
	   List<BillHeaderDB> billDBs=billDao.getBills(1,BillType.pharmacy.toString());
		  List<PharBillDB> billDB2s=new ArrayList<PharBillDB>();
		  for (BillHeaderDB b:billDBs) {
			billDB2s.add(new PharBillDB(b.getBillNumber(), 
					                    b.getClaimNumber(), 
					                    b.getDate(), 
					                    b.getSsn(), 
					                    b.getStatus(),
					                    b.getTotalCharge(),
					                    b.getCustomerPay(),
					                    b.getBillType(),
					                    b.getTotalCoverage()));
		}
		  for (PharBillDB b:billDB2s) {
			List<BillInfoDB> bInfoDBs=bInfoDao.findBillInfoBillNum(b.getBillNumber());
			b.setInfoDBs(bInfoDBs);
		}
		 
		  return billDB2s;
	
  }
   public List<HosBillDB> findAllHosBills()
   {
	   List<BillHeaderDB> billDBs=billDao.getBills(1, BillType.hospital.toString());
		  List<HosBillDB> billDB2s=new ArrayList<HosBillDB>();
		  for (BillHeaderDB b:billDBs) {
			billDB2s.add(new HosBillDB(b.getBillNumber(), 
					                    b.getClaimNumber(), 
					                    b.getDate(), 
					                    b.getSsn(), 
					                    b.getStatus(),
					                    b.getTotalCharge(),
					                    b.getCustomerPay(),
					                    b.getBillType(),
					                    b.getTotalCoverage()));
		}
		  for (HosBillDB b:billDB2s) {
			List<HosBillInfoDB> bInfoDBs=hInfoDao.findBillInfoBillNum(b.getBillNumber());
			b.setInfoDBs(bInfoDBs);
		}
		 
		  return billDB2s;
   }
public void save(BillHeaderDB header) {
	billDao.save(header);
	
}
public List<PharBillDB> searchPharBillBySSN(String ssn,int status)
{
	  List<BillHeaderDB> billDBs=billDao.searchBills(ssn, status);
	  List<PharBillDB> billDB2s=new ArrayList<PharBillDB>();
	  for(int i=0;i<billDBs.size();i++)
	  {
		    
			if (!billDBs.get(i).getBillType().equals(BillType.pharmacy.toString())) {
				billDBs.remove(i);
				--i;
			}
		  }
	  for (BillHeaderDB b:billDBs) {
		billDB2s.add(new PharBillDB(b.getBillNumber(), 
				                    b.getClaimNumber(), 
				                    b.getDate(), 
				                    b.getSsn(), 
				                    b.getStatus(),
				                    b.getTotalCharge(),
				                    b.getCustomerPay(),				                    
				                    b.getBillType(),
				                    b.getTotalCoverage()));
	}
	  for (PharBillDB b:billDB2s) {
		List<BillInfoDB> bInfoDBs=bInfoDao.findBillInfoBillNum(b.getBillNumber());
		b.setInfoDBs(bInfoDBs);
	}
	 
	  return billDB2s;
}
public List<HosBillDB> searchHosBillBySSN(String ssn,int status)
{
	  List<BillHeaderDB> billDBs=billDao.searchBills(ssn, status);
	  List<HosBillDB> billDB2s=new ArrayList<HosBillDB>();	 	  
	  for(int i=0;i<billDBs.size();i++)
	  {
		    
			if (!billDBs.get(i).getBillType().equals(BillType.hospital.toString())) {
				billDBs.remove(i);
				--i;
			}
		  }
	  for (BillHeaderDB b:billDBs) {
		billDB2s.add(new HosBillDB(b.getBillNumber(), 
				b.getClaimNumber(), 
				b.getDate(), 
				b.getSsn(), 
				b.getStatus(),
				b.getTotalCharge(),
				b.getCustomerPay(),
				b.getBillType(),
				b.getTotalCoverage()));
	}
	  for (HosBillDB b:billDB2s) {
		List<HosBillInfoDB> bInfoDBs=hInfoDao.findBillInfoBillNum(b.getBillNumber());
		b.setInfoDBs(bInfoDBs);
	}
	 
	  return billDB2s;
}
}
