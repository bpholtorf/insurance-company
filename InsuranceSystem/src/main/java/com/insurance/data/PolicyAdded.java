package com.insurance.data;

public class PolicyAdded {
	
	private int id;
	private String policyName;
	private String policyNumber;
	private String planType;
	private int payPeriod;
	private Double amount;
	private Double deductible;
	private Double premiumPercent;
	private String check;
	
	public PolicyAdded(int id,String policyName,String policyNumber,String planType,int payPeriod,double amount,double deductible,double premiumPercent,String check){
		super();
		this.id=id;
		this.policyName=policyName;
		this.policyNumber=policyNumber;
		this.planType=planType;
		this.payPeriod=payPeriod;
		this.amount=amount;
		this.deductible=deductible;
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
	
	public Double getAmount(){
		return amount;
	}
	public void setAmount(Double amount){
		this.amount=amount;
	}
	
	public Double getDeductible(){
		return deductible;
	}
	public void setDeductible(Double deductible){
		this.deductible=deductible;
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
