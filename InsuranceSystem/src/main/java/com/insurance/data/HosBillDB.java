package com.insurance.data;

import java.util.Date;
import java.util.List;

public class HosBillDB {
   public HosBillDB(String billNumber, String claimNumber, Date date, String ssn,
			int status, double totalCharge, String billType) {
		super();
		this.billNumber = billNumber;
		this.claimNumber = claimNumber;
		this.date = date;
		this.ssn = ssn;
		this.status = status;
		this.totalCharge = totalCharge;
		this.billType = billType;
	}
private String billNumber;
	
	private String claimNumber;
	
    private Date date;
	
    private String ssn;
	
	private int status;
	
	private List<HosBillInfoDB> infoDBs;
	
	private double totalCharge;
	
	private double customerPay;
	
	private String billType;
	private double totalCoverage;
	
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<HosBillInfoDB> getInfoDBs() {
		return infoDBs;
	}
	public HosBillDB(String billNumber, String claimNumber, Date date, String ssn,
			int status, List<HosBillInfoDB> infoDBs, double totalCharge,
			double customerPay, String billType, double totalCoverage) {
		super();
		this.billNumber = billNumber;
		this.claimNumber = claimNumber;
		this.date = date;
		this.ssn = ssn;
		this.status = status;
		this.infoDBs = infoDBs;
		this.totalCharge = totalCharge;
		this.customerPay = customerPay;
		this.billType = billType;
		this.totalCoverage = totalCoverage;
	}
	public HosBillDB(String billNumber, String claimNumber, Date date, String ssn,
			int status, double totalCharge, double customerPay,
			String billType, double totalCoverage) {
		super();
		this.billNumber = billNumber;
		this.claimNumber = claimNumber;
		this.date = date;
		this.ssn = ssn;
		this.status = status;
		this.totalCharge = totalCharge;
		this.customerPay = customerPay;
		this.billType = billType;
		this.totalCoverage = totalCoverage;
		
	}
	public void setInfoDBs(List<HosBillInfoDB> infoDBs) {
		this.infoDBs = infoDBs;
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
	public double getTotalCoverage() {
		return totalCoverage;
	}
	public void setTotalCoverage(double totalCoverage) {
		this.totalCoverage = totalCoverage;
	}
	
}
