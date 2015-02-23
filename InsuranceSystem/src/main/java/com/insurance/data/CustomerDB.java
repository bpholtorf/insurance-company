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

	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
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
	
	@Column(name="gender")
	private String gender;

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
