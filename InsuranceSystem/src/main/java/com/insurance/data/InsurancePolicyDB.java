package com.insurance.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.insurance.validator.PolicyNumber;

@Entity
@Table(name="insurance_policy")
public class InsurancePolicyDB implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;

	@Column(name="policyName")
	@NotEmpty(message="Please input the policy name")
	private String policyName;
	
	@Column(name="planType")
	private String planType;
	
	@Column(name="premiumPercent")
	@NotNull(message="Please input the premium percent")
	private Double premiumPercent;
	


	@Column(name="pamount")
	@NotNull(message="Please input the max pharmacy coverage")
	private Double pamount;

	@Column(name="hamount")
	@NotNull(message="Please input the max hospital amount")
	private Double hamount;

	@Column(name="pAmount")
	@NotNull(message="Please input the max pharmacy coverage")
	private Double pAmount;


	
	@Column(name="policyNumber")
	@NotEmpty(message="Please input the policy number")
	@PolicyNumber(message="Policy number already exsits",entity=PolicyNumber.class)
	private String policyNumber;
	
	@Column(name="payPeriod")
	private Integer payPeriod;
	

	@Column(name="hAmount")
	@NotNull(message="Please input the max hospital coverage")
	private Double hAmount;


	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public Double getPremiumPercent() {
		return premiumPercent;
	}

	public void setPremiumPercent(Double premiumPercent) {
		this.premiumPercent = premiumPercent;
	}


	public Double getHamount() {
		return hamount;
	}

	public void setHamount(Double hamount) {
		this.hamount = hamount;

	}

	public Double getpAmount() {
		return pAmount;
	}

	public void setpAmount(Double pAmount) {
		this.pAmount = pAmount;

	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Integer getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(Integer payPeriod) {
		this.payPeriod = payPeriod;
	}


	public Double getPamount() {
		return pamount;
	}

	public void setPamount(Double pamount) {
		this.pamount = pamount;

	}

	public Double gethAmount() {
		return hAmount;
	}

	public void sethAmount(Double hAmount) {
		this.hAmount = hAmount;

	}


	
}