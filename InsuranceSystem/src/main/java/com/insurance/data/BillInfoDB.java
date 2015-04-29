package com.insurance.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="billInfo")
public class BillInfoDB implements Serializable{
  @Id
  @Column(name="claimId")
  private String claimId;
  @Id
  @Column(name="drugId")
  private String drugId;
  @Column(name="type")
  private String type;
  @Column(name="name")
  private String name;
  @Column(name="amount")
  private String amount;
  @Column(name="totalCharge")
  private double totalCharge;
  @Column(name="coverage")
  private double coverage;
  @Column(name="billId")
  private String billId;
  @Column(name="status")
  private int status;
  @Column(name="ssn")
  private int ssn;
public String getClaimId() {
	return claimId;
}
public void setClaimId(String claimId) {
	this.claimId = claimId;
}
public String getDrugId() {
	return drugId;
}
public void setDrugId(String drugId) {
	this.drugId = drugId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public double getTotalCharge() {
	return totalCharge;
}
public void setTotalCharge(double totalCharge) {
	this.totalCharge = totalCharge;
}
public double getCoverage() {
	return coverage;
}
public void setCoverage(double coverage) {
	this.coverage = coverage;
}
public String getBillId() {
	return billId;
}
public void setBillId(String billId) {
	this.billId = billId;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getSsn() {
	return ssn;
}
public void setSsn(int ssn) {
	this.ssn = ssn;
}
  
}
