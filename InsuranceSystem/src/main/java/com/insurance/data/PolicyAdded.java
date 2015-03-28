package com.insurance.data;

public class PolicyAdded {
	
	private int id;
	private String policyName;
	private String policyNumber;
	private String planType;
	private int payPeriod;
	private Double pamount;
	private Double hamount;
	private Double premiumPercent;
	private String check;
	
	public PolicyAdded(int id,String policyName,String policyNumber,String planType,int payPeriod,double pamount,double hamount,double premiumPercent,String check){
		super();
		this.id=id;
		this.policyName=policyName;
		this.policyNumber=policyNumber;
		this.planType=planType;
		this.payPeriod=payPeriod;
		this.pamount=pamount;
		this.hamount=hamount;
		this.premiumPercent=premiumPercent;
		this.check=check;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getPolicyName(){
		return policyName;
	}
	public void setPolicyName(String policyName){
		this.policyName=policyName;
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
	
	public int getPayPeriod(){
		return payPeriod;
	}
	public void setPayPeriod(int payPeriod){
		this.payPeriod=payPeriod;
	}
	
	public Double getPamount(){
		return pamount;
	}
	public void setPamount(Double pamount){
		this.pamount=pamount;
	}
	
	public Double getHamount(){
		return hamount;
	}
	public void setHamount(Double hamount){
		this.hamount=hamount;
	}
	
	public Double getPremiumPercent(){
		return premiumPercent;
	}
	public void setPremiumPercent(Double premiumPercent){
		this.premiumPercent=premiumPercent;
	}
	
	public String getCheck(){
		return check;
	}
	public void setCheck(String check){
		this.check=check;
	}

}
