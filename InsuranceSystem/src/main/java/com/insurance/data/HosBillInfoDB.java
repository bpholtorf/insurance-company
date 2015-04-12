package com.insurance.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hosBillIInfo")
public class HosBillInfoDB {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "billNumber")
	private String billNumber;
	@Column(name = "price")
	private double price;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "itemType")
	private String itemType;
	@Column(name = "operatorTitle")
	private String operatorTitle;
	@Column(name = "coverage")
	private double coverage;
    @Column(name="isCovered")
	private boolean isCovered;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getOperatorTitle() {
		return operatorTitle;
	}

	public void setOperatorTitle(String operatorTitle) {
		this.operatorTitle = operatorTitle;
	}

}
