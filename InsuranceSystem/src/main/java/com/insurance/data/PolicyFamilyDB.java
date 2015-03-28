package com.insurance.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="policy_family")
public class PolicyFamilyDB implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="pid")
	private int pid;
	
	@Column(name="cid")
	private int cid;
	
	@Column(name="memberName")
	private String memberName;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public int getPid(){
		return pid;
	}
	public void setPid(int pid){
		this.pid=pid;
	}

	public int getCid(){
		return cid;
	}
	public void setCid(int cid){
		this.cid=cid;
	}
	
	public String getMemberName(){
		return memberName;
	}
	public void setMemberName(String memberName){
		this.memberName=memberName;
	}
}
