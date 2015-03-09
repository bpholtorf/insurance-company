package com.insurance.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerPolicy")
public class CustomerPolicyDB implements Serializable{
	
	@Id
	@Column(name="cid")
	private Integer cid;
	
	@Id
	@Column(name="pid")
	private Integer pid;
	
	@Column(name="coverage")
	private Double coverage;
	
	@Column(name="premium")
	private Double premium;
	
	@Column(name="payPeriod")
	private Integer payPeriod;
	
	@Column(name="amountLeft")
	private Double amountLeft;
	
	public int getCid(){
		return cid;
	}
	public void setCid(int cid){
		this.cid=cid;
	}
	
	public Integer getPid(){
		return pid;
	}
	public void setPid(Integer pid){
		this.pid=pid;
	}
	
	public Double getCoverage(){
		return coverage;
	}
	public void setCoverage(Double coverage){
		this.coverage=coverage;
	}
	
	public Double getPremium(){
		return premium;
	}
	public void setPremium(Double premium){
		this.premium=premium;
	}
	
	public Integer getPayPeriod(){
		return payPeriod;
	}
	public void setPayPeriod(Integer payPeriod){
		this.payPeriod=payPeriod;
	}
	
	public Double gerAmountLeft(){
		return amountLeft;
	}
	public void setAmountLeft(Double amountLeft){
		this.amountLeft=amountLeft;
	}
	
}
