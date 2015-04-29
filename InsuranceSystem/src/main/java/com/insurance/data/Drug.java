package com.insurance.data;


public class Drug {
    public Drug(String drugId, String drugName, int contains) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
		this.contains = contains;
	}

	private String drugId;
	private String drugName;
    private int contains;
	

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getContains() {
		return contains;
	}

	public void setContains(int contains) {
		this.contains = contains;
	}
}
