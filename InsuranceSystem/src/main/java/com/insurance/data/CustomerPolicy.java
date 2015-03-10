package com.insurance.data;


import java.util.Date;




public class CustomerPolicy {
	
	private int cid;	
	private int pid;
	private String policyNumber;
	private Double premium;
	private Double deductibleLeft;
	private Double amountLeft;
	private Date dateFrom;
	private Date dateTo;
	private String cname;
	
	public CustomerPolicy(int cid,int pid,String policyNumber,double premium,double deductibleLeft,double amountLeft,Date dateFrom,Date dateTo,String cname){
		super();
		this.cid=cid;
		this.pid=pid;
		this.policyNumber=policyNumber;
		this.premium=premium;
		this.deductibleLeft=deductibleLeft;
		this.amountLeft=amountLeft;
		this.dateFrom=dateFrom;
		this.dateTo=dateTo;
		this.cname=cname;
		
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
	
	public Double getPremium(){
		return premium;
	}
	public void setPremium(Double premium){
		this.premium=premium;
	}
	
	public Double getDeductibleLeft(){
		return deductibleLeft;
	}
	public void setDeductibleLeft(Double deductibleLeft){
		this.deductibleLeft=deductibleLeft;
	}
	
	public Double getAmountLeft(){
		return amountLeft;
	}
	public void setAmountLeft(Double amountLeft){
		this.amountLeft=amountLeft;
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
	
}
