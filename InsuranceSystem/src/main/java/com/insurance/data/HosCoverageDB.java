package com.insurance.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospitalCoverage")
public class HosCoverageDB {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "policyType")
	private String policyType;
	@Column(name = "deductible")
	private double deductible;
	@Column(name="operatorTitle")
	 private String operatorTitle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getDeductible() {
		return deductible;
	}

	public void setDeductible(double deductible) {
		this.deductible = deductible;
	}

	public String getOperatorTitle() {
		return operatorTitle;
	}

	public void setOperatorTitle(String operatorTitle) {
		this.operatorTitle = operatorTitle;
	}

	

}
