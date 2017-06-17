package com.gpfs.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "company")
public class Company {

	@Id
	@GeneratedValue
	Long id;

	@Column(name= "company_name")
	String name; 
	@Column(name= "tin")
	String tin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
}

