package com.insurance.data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="billHeader")
public class BillHeaderDB implements Serializable {
	@Id
	@Column(name="billNumber")
    private String billNumber;
	@Column(name="claimNumber")
	private String claimNumber;
	@Column(name="date")
    private Date date;
	@Column(name="ssn")
    private int ssn;
	@Column(name="status")
	private int status;
	
	@Column(name="totalCharge")
	private double totalCharge;
	
	@Column(name="customerPay")
	private double customerPay;
	
	@Column(name="billType")
	private String billType;
	
	
	@Column(name="totalCoverage")
	private double totalCoverage;
	public double getTotalCoverage() {
		return totalCoverage;
	}
	public void setTotalCoverage(double totalCoverage) {
		this.totalCoverage = totalCoverage;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public double getCustomerPay() {
		return customerPay;
	}
	public void setCustomerPay(double customerPay) {
		this.customerPay = customerPay;
	}
	public double getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
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
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
}
