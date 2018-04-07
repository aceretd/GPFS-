//package com.gpfs.coa.model;
//
//import java.math.BigDecimal;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//
//import com.gpfs.core.model.BaseEntity;
//
//@Entity(name = "fs_level_6")
//public class FSLevel6 extends BaseEntity {
//
//	private static final long serialVersionUID = 1L;
//
//	@Column(name = "name", nullable = false)
//	private String name;
//
//	@Column(name = "acct_no", nullable = false)
//	private String accountNumber;
//
//	@Column(name = "description")
//	private String description;
//
//	@Column(name = "curr_yr", nullable = false)
//	private BigDecimal currentYearAmount;
//
//	@Column(name = "prev_yr", nullable = false)
//	private BigDecimal previousYearAmount;
//
//	@Column(name = "code")
//	private String code;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAccountNumber() {
//		return accountNumber;
//	}
//
//	public void setAccountNumber(String accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public BigDecimal getCurrentYearAmount() {
//		return currentYearAmount;
//	}
//
//	public void setCurrentYearAmount(BigDecimal currentYearAmount) {
//		this.currentYearAmount = currentYearAmount;
//	}
//
//	public BigDecimal getPreviousYearAmount() {
//		return previousYearAmount;
//	}
//
//	public void setPreviousYearAmount(BigDecimal previousYearAmount) {
//		this.previousYearAmount = previousYearAmount;
//	}
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//	
//}
