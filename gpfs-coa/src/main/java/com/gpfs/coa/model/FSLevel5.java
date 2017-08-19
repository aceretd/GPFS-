package com.gpfs.coa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "fs_level_5")
public class FSLevel5 extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "acct_no", nullable = false)
	private String accountNumber;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "parent_id")
	private List<FSLevel6> children;

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

	public List<FSLevel6> getChildren() {
		return children;
	}

	public void setChildren(List<FSLevel6> children) {
		this.children = children;
	}

}
