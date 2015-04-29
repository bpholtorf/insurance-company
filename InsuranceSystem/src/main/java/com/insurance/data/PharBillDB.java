package com.insurance.data;


import java.util.Date;
import java.util.List;


public class PharBillDB{
	
   
	private String billNumber;
	
	private String claimNumber;
	
    private Date date;
	
    private String ssn;
	
	private int status;
	
	private List<BillInfoDB> infoDBs;
	
	private double preCoverage;
	private double nonPreCoverage;
	
	private double totalCharge;
	
	private double customerPay;
	
	private double totalCoverage;
	private String billType;
    public double getTotalCoverage() {
		return totalCoverage;
	}
	public void setTotalCoverage(double totalCoverage) {
		this.totalCoverage = totalCoverage;
	}
	public PharBillDB(String billNumber, String claimNumber, Date date, String ssn,
			int status,
			double totalCharge,double customerPay, String billType,double totalCoverage) {
		super();
		this.billNumber = billNumber;
		this.claimNumber = claimNumber;
		this.date = date;
		this.ssn = ssn;
		this.status = status;
		
		this.totalCharge = totalCharge;
		this.customerPay=customerPay;
		this.billType=billType;
		this.totalCoverage=totalCoverage;
		
	}
	public PharBillDB(String billNumber, String claimNumber, Date date, String ssn,
			int status, String billType) {
		super();
		this.billNumber = billNumber;
		this.claimNumber = claimNumber;
		this.date = date;
		this.ssn = ssn;
		this.status = status;
		this.billType=billType;
	}
	public PharBillDB(String billNumber, String claimNumber, Date date, String ssn,
			int status, List<BillInfoDB> infoDBs,
			 double totalCharge,double customerPay, String billType, double totalCoverage) {
		super();
		this.billNumber = billNumber;
		this.claimNumber = claimNumber;
		this.date = date;
		this.ssn = ssn;
		this.status = status;
		this.infoDBs = infoDBs;
		
		this.totalCharge = totalCharge;
		this.customerPay=customerPay;
		this.billType=billType;
		this.totalCharge=totalCharge;
		this.totalCoverage=totalCoverage;
	}
	
	public double getPreCoverage() {
		return preCoverage;
	}
	public void setPreCoverage(double preCoverage) {
		this.preCoverage = preCoverage;
	}
	public double getNonPreCoverage() {
		return nonPreCoverage;
	}
	public void setNonPreCoverage(double nonPreCoverage) {
		this.nonPreCoverage = nonPreCoverage;
	}
	public List<BillInfoDB> getInfoDBs() {
		return infoDBs;
	}
	public void setInfoDBs(List<BillInfoDB> infoDBs) {
		this.infoDBs = infoDBs;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public double getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
	public double getCustomerPay() {
		return customerPay;
	}
	public void setCustomerPay(double customerPay) {
		this.customerPay = customerPay;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	
}
