package com.insurance.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerDB implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="incomeStatus")
	private String incomeStatus;
	
	@Column(name="sponsorInfo")
	private String sponsorInfo;
	
	@Column(name="employerInfo")
	private String employerInfo;

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	
	public Date getDateOfBirth(){
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth=dateOfBirth;
	}
	
	public String getIncomeStatus(){
		return incomeStatus;
	}
	public void setIncomeStatus(String incomeStatus){
		this.incomeStatus=incomeStatus;
	}
	
	public String getSponsorInfo(){
		return sponsorInfo;
	}
	public void setSponsorInfo(String sponsorInfo){
		this.sponsorInfo=sponsorInfo;
	}
	
	public String getEmployerInfo(){
		return employerInfo;
	}
	public void setEmployerInfo(String employerInfo){
		this.employerInfo=employerInfo;
	}
}
