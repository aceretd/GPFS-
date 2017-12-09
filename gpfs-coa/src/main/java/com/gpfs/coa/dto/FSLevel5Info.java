package com.gpfs.coa.dto;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.gpfs.core.model.BaseEntity;

public class FSLevel5Info extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String accountNumber;
	private List<FSLevel6Info> children = Lists.newArrayList();

	public FSLevel6Info getChildByAccountNumber(String accountNumber) {
		Optional<FSLevel6Info> fs6Opt = this.getChildren().stream().filter(fs6 -> accountNumber.equals(fs6.getAccountNumber())).findFirst();
		if (fs6Opt.isPresent()) {
			return fs6Opt.get();
		}
		return null;
	}

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
