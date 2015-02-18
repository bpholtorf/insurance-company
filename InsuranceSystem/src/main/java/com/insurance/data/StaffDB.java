package com.insurance.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="staff")
public class StaffDB implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password", columnDefinition="default '8888'")
	private String password;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="SSN")
	private String SSN;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
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
	
	public String getSSN(){
		return SSN;
	}
	public void setSSN(String SSN){
		this.SSN=SSN;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
