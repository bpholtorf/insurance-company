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
	
	@Column(name="deductible")
	@NotNull(message="Please input the deductible")
	private Double deductible;
	
	@Column(name="policyNumber")
	@NotEmpty(message="Please input the policy number")
	private String policyNumber;
	
	@Column(name="payPeriod")
	private Integer payPeriod;
	
	@Column(name="amount")
	@NotNull(message="Please input the max annual payout")
	private Double amount;
	
	
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

	public Double getDeductible() {
		return deductible;
	}

	public void setDeductible(Double deductible) {
		this.deductible = deductible;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	
}