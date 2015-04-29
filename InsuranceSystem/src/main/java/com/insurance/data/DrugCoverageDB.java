package com.insurance.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drug_coverage")
public class DrugCoverageDB {
	public DrugCoverageDB() {
		super();
	}

	public DrugCoverageDB(String drugId, String drugName) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
	}

	@Id
	@Column(name = "drug_id")
	
	private String drugId;
	
	@Column(name = "drug_name_commercial")
	private String drugName;

	

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
	
	
	
}
