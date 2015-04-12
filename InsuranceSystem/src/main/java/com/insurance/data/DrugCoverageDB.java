package com.insurance.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drug_coverage")
public class DrugCoverageDB {
	@Id
	@Column(name = "drug_id")
	
	private int drugId;
	
	@Column(name = "drug_name_commercial")
	private String drugName;

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	
	
	
}
