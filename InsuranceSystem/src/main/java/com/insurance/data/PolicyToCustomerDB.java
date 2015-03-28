package com.insurance.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="policy_customer")
public class PolicyToCustomerDB implements Serializable{
	@Id
	@Column(name="cid")
	private int cid;
	
	@Id 
	@Column(name="pid")
	private int pid;
	
	@Column(name="policyNumber")
	private String policyNumber;
	
	@Column(name="premium")
	private double premium;
	
	@Column(name="pamountLeft")
	private double pamountLeft;
	
	@Column(name="hamountLeft")
	private double hamountLeft;
	
	@Column(name="dateFrom")
	private Date dateFrom;
	
	@Column(name="dateTo")
	private Date dateTo;
	
	public int getCid(){
		return cid;
	}
	public void setCid(int cid){
		this.cid=cid;
	}
	
	public int getPid(){
		return pid;
	}
	public void setPid(int pid){
		this.pid=pid;
	}
	
	public String getPolicyNumber(){
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber){
		this.policyNumber=policyNumber;
	}
	
	public double getPremium(){
		return premium;
	}
	public void setPremium(double premium){
		this.premium=premium;
	}
	
	public double getPamountLeft(){
		return pamountLeft;
	}
	public void setPamountLeft(double pamountLeft){
		this.pamountLeft=pamountLeft;
	}
	
	public double getHamountLeft(){
		return hamountLeft;
	}
	public void setHamountLeft(double hamountLeft){
		this.hamountLeft=hamountLeft;
	}
	
	public Date getDateFrom(){
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom){
		this.dateFrom=dateFrom;
	}
	
	public Date getDateTo(){
		return dateTo;
	}
	public void setDateTo(Date dateTo){
		this.dateTo=dateTo;
	}

}
