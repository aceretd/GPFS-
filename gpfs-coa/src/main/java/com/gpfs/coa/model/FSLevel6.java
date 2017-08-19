package com.gpfs.coa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "fs_level_6")
public class FSLevel6 extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "parent_id")
	private FSLevel5 parent;

	@Column(name = "acct_no", nullable = false)
	private String accountNumber;

	@Column(name = "description")
	private String description;

	@Column(name = "curr_yr", nullable = false)
	private BigDecimal currentYearAmount;

	@Column(name = "prev_yr", nullable = false)
	private BigDecimal previousYearAmount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FSLevel5 getParent() {
		return parent;
	}

	public void setParent(FSLevel5 parent) {
		this.parent = parent;
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
	
}
