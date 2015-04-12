package com.insurance.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="policy_coverage")
public class PolicyCoverage implements Serializable{
	@Id
  @Column(name="pid")
  private int pid;
	@Id
  @Column(name="itemName")
  private String itemName;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}

  
  
  
}
