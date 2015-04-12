package com.insurance.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billInfo")
public class BillInfoDB implements Serializable {
	@Id
	@Column(name = "drugId")
	private String drugId;

	@Id
	@Column(name = "billNumber")
	private String billNumber;
    
	@Column(name = "type")
	private String type;
	@Column(name = "name")
	private String name;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "totalCharge")
	private double totalCharge;
    @Column(name="isCovered")
	private boolean isCovered;
    @Column(name="coverage")
    
	private double  coverage;
	public boolean isCovered() {
		return isCovered;
	}

	public void setCovered(boolean isCovered) {
		this.isCovered = isCovered;
	}

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	
	

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	

}
