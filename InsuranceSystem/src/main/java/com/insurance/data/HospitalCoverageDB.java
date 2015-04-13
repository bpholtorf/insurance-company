package com.insurance.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="hospitalcoverage")
public class HospitalCoverageDB implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;

	@Column(name="itemName")
	@NotEmpty(message="Please input the item name")
	private String itemName;
	
	@Column(name="policyType")
	@NotEmpty(message="Please input the policy type")
	private String policyType;
	
	@Column(name="deductible")
	@NotNull(message="Please input the deductible")
	private Double deductible;

	@Column(name="operatorTitle")
	@NotNull(message="Please input the operator title")
	private String operatorTitle;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Double getDeductible() {
		return deductible;
	}

	public void setDeductible(Double deductible) {
		this.deductible = deductible;
	}

	public String getOperatorTitle() {
		return operatorTitle;
	}

	public void setOperatorTitle(String operatorTitle) {
		this.operatorTitle = operatorTitle;
	}

	
}