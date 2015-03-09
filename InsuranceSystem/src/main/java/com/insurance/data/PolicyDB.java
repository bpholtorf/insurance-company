package com.insurance.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_policy")
public class PolicyDB implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="policyName")
	private String policyName;
	
	@Column(name="policyNumber")
	private String policyNumber;
	
	@Column(name="planType")
	private String planType;
	
	@Column(name="payPeriod")
	private int payPeriod;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="deductible")
	private Double deductible;
	
	@Column(name="premiumPercent")
	private Double premiumPercent;
	
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

}
