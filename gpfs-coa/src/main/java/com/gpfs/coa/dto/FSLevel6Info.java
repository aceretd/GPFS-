package com.gpfs.coa.dto;

import java.math.BigDecimal;

import com.gpfs.core.model.BaseEntity;

public class FSLevel6Info extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String accountNumber;
	private String description;
	private String code;
	private BigDecimal currentYearAmount;
	private BigDecimal previousYearAmount;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getCurrentYearAmount() {
		return currentYearAmount;
	}
	public void setCurrentYearAmount(BigDecimal currentYearAmount) {
		this.currentYearAmount = currentYearAmount;
	}
	public BigDecimal getPreviousYearAmount() {
		return previousYearAmount;
	}
	public void setPreviousYearAmount(BigDecimal previousYearAmount) {
		this.previousYearAmount = previousYearAmount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
