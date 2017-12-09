package com.gpfs.coa.dto;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.gpfs.core.model.BaseEntity;

public class FSLevel4Info extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String accountNumber;
	private List<FSLevel5Info> children = Lists.newArrayList();

	public FSLevel5Info getChildByAccountNumber(String accountNumber) {
		Optional<FSLevel5Info> fs5Opt = this.getChildren().stream().filter(fs5 -> accountNumber.equals(fs5.getAccountNumber())).findFirst();
		if (fs5Opt.isPresent()) {
			return fs5Opt.get();
		}
		return null;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FSLevel5Info> getChildren() {
		return children;
	}
	public void setChildren(List<FSLevel5Info> children) {
		this.children = children;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
