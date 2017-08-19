package com.gpfs.coa.dto;

import java.util.List;

import com.gpfs.core.model.BaseEntity;

public class FSLevel5Info extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String accountNumber;
	private List<FSLevel6Info> children;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FSLevel6Info> getChildren() {
		return children;
	}
	public void setChildren(List<FSLevel6Info> children) {
		this.children = children;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
