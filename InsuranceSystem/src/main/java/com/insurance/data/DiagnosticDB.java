package com.insurance.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diagnostic_test")
public class DiagnosticDB implements Serializable{

	@Id
	@Column(name="diagnostic_test_id")
	private int diagnostic_test_id;
	
	@Column(name="diagnostic_test_name")
	private String diagnostic_test_name;
	
	@Column(name="cost")
	private double cost;
	
	public int getDiagnostic_test_id(){
		return diagnostic_test_id;
	}
	public void setDiagnostic_test_id(int diagnostic_test_id){
		this.diagnostic_test_id=diagnostic_test_id;
	}
	
	public String getDiagnostic_test_name(){
		return diagnostic_test_name;
	}
	public void setDiagnostic_test_name(String diagnostic_test_name){
		this.diagnostic_test_name=diagnostic_test_name;
	}
	
	public double getCost(){
		return cost;
	}
	public void setCost(double cost){
		this.cost=cost;
	}
}
