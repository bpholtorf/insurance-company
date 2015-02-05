package com.insurance.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="claim")
public class ClaimDB implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="cid")
	private Integer cid;
	
	@Column(name="pid")
	private Integer pid;
	
	@Column(name="dateOfVisit")
	private Date dateOfVisit;
	
	@Column(name="placeOfVisit")
	private String placeOfVisit;
	
	@Column(name="visitType")
	private String visitType;
	
	@Column(name="dateOfClaim")
	private Date dateOfClaim;
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getCid(){
		return cid;
	}
	public void setCid(Integer cid){
		this.cid=cid;
	}
	
	public Date getDateOfVisit(){
		return dateOfVisit;
	}
	public void setDateOfVisit(Date dateOfVisit){
		this.dateOfVisit=dateOfVisit;
	}
	
	public String getPlaceOfVisit(){
		return placeOfVisit;
	}
	public void setPlaceOfVisit(String placeOfVisit){
		this.placeOfVisit=placeOfVisit;
	}
	
	public Date getDateOfClaim(){
		return dateOfClaim;
	}
	public void setDateOfClaim(Date dateOfClaim){
		this.dateOfClaim=dateOfClaim;
	}

}
