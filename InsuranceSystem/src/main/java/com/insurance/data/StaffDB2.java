package com.insurance.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.insurance.validator.Password;
import com.insurance.validator.Phone;
import com.insurance.validator.Username;





@Entity
@Table(name="staff")

public class StaffDB2 implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="username",unique = true)
	
	private String username;
	
	@Column(name="password")
	
	private String password;
	
	
	
	@Column(name="firstName")
	
	private String firstName;
	
	@Column(name="lastName")
	
	private String lastName;
	
	@Column(name="SSN")
	
	private String SSN;
	
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
	private Date dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	@Column(name="able")
	private int able;
	public int getAble() {
		return able;
	}
	public void setAble(int able) {
		this.able = able;
	}
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
