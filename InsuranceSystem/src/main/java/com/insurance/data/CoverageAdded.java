package com.insurance.data;

public class CoverageAdded {
	
	private String itemName;
	private String policyType;
	private Double deductible;
	private String operatorTitle;
	private String check;
	
	public CoverageAdded(Integer id,String itemName,String policyType, Double deductible,String operatorTitle, String check){
		super();
		this.id=id;
		this.itemName = itemName;
		this.policyType=policyType;
		this.deductible = deductible;
		this.operatorTitle = operatorTitle;
		this.check=check;
	}
	
	private int id;
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

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}



}
