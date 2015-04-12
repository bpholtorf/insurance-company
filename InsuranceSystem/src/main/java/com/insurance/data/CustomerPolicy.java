package com.insurance.data;


import java.util.Date;




public class CustomerPolicy {
	
	private int cid;	
	private int pid;
	private String policyNumber;
	private String planType;
	private Double premium;
	private Double hamountLeft;
	private Double pamountLeft;
	private Date dateFrom;
	private Date dateTo;
	private String cname;
	private String SSN;
	
	public CustomerPolicy(int cid,int pid,String policyNumber,String planType,double premium,double pamountLeft,double hamountLeft,Date dateFrom,Date dateTo,String cname,String SSN){
		super();
		this.cid=cid;
		this.pid=pid;
		this.policyNumber=policyNumber;
		this.planType=planType;
		this.premium=premium;
		this.hamountLeft=hamountLeft;
		this.pamountLeft=pamountLeft;
		this.dateFrom=dateFrom;
		this.dateTo=dateTo;
		this.cname=cname;
		this.SSN=SSN;
		
	}
	
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
	
	public String getPlanType(){
		return planType;
	}
	public void setPlanType(String planType){
		this.planType=planType;
	}
	
	public Double getPremium(){
		return premium;
	}
	public void setPremium(Double premium){
		this.premium=premium;
	}
	
	public Double getHamountLeft(){
		return hamountLeft;
	}
	public void setHamountLeft(Double hAmountLeft){
		this.hamountLeft=hAmountLeft;
	}
	
	public Double getPamountLeft(){
		return pamountLeft;
	}
	public void setPamountLeft(Double pamountLeft){
		this.pamountLeft=pamountLeft;
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
	
	public String getCname(){
		return cname;
	}
	public void setCname(String cname){
		this.cname=cname;
	}
	
	public String getSSN(){
		return SSN;
	}
	public void setSSN(String SSN){
		this.SSN=SSN;
	}
	
}
