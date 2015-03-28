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

import com.insurance.validator.Password;
import com.insurance.validator.Phone;
import com.insurance.validator.Username;
import com.insurance.validator.SSN;




@Entity
@Table(name="staff")

public class StaffDB implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="username",unique = true)
	@NotEmpty(message="Please input the username")
	@Username(message="Username already exsits",entity=StaffDB.class)
	private String username;
	
	@Column(name="password")
	@NotEmpty(message="Please input the password")
	@Password(message="6 to 20 characters string with at least one digit, one uppercase letter, one lowercase letter and one special symbol")
	private String password;
	
	
	
	@Column(name="firstName")
	@NotEmpty(message="Please input the first name")
	private String firstName;
	
	@Column(name="lastName")
	@NotEmpty(message="Please input the last name")
	private String lastName;
	
	@Column(name="SSN")
	@NotEmpty(message="Please input the SSN")
	@Pattern(regexp="\\d{9}",message="SSN should be 9 digits without space and dash")
	@SSN(message="SSN already exsits",entity=SSN.class)
	private String SSN;
	
	@Column(name="address")
	@NotEmpty(message="Please input the address")
	private String address;
	
	@Column(name="phoneNumber")
	@NotEmpty(message="Please input the phone number")
	@Phone(message="Please input a correct phone number")
	private String phoneNumber;
	
	@Column(name="email")
	@NotEmpty(message="Please input the email")
	@Email(message="Please input the correct email")
	private String email;
	
	@Column(name="dateOfBirth")
	@Past(message="Please input a past date")
	private Date dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="able")
	private int able;
	
	@Column(name="name")
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public int getAble(){
		return able;
	}
	public void setAble(int able){
		this.able=able;
	}
	
}
