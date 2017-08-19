package com.gpfs.coa.dto;

import java.util.List;

import com.gpfs.core.model.BaseEntity;

public class FSLevel3Info extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<FSLevel4Info> children;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FSLevel4Info> getChildren() {
		return children;
	}
	public void setChildren(List<FSLevel4Info> children) {
		this.children = children;
	}

}
