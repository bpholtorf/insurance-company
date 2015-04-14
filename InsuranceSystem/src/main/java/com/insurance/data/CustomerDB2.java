package com.insurance.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.insurance.validator.Phone;
import com.insurance.validator.SSNCustomer;

@Entity
@Table(name="customer")
public class CustomerDB2 implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;

	@Column(name="firstName")
	@NotEmpty(message="Please input the first name")
	private String firstName;
	
	@Column(name="lastName")
	@NotEmpty(message="Please input the last name")
	private String lastName;
	
	@Column(name="address")
	@NotEmpty(message="Please input the address")
	private String address;
	
	@Column(name="phoneNumber")
	@NotEmpty(message="Please input the phone number")
	@Phone(message="Please input the correct phone number")
	private String phoneNumber;
	
	@Column(name="email")
	@NotEmpty(message="Please input the email")
	@Email(message="Please input the correct email")
	private String email;
	
	@Column(name="dateOfBirth")
	@Past(message="Please input a past date")
	private Date dateOfBirth;
	
	@Column(name="incomeStatus")
	private String incomeStatus;
	
	@Column(name="sponsorInfo")
	private String sponsorInfo;
	
	@Column(name="employerInfo")
	private String employerInfo;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="SSN")
	private String SSN;

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
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
}
