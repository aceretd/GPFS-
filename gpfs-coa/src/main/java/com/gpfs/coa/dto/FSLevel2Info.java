package com.gpfs.coa.dto;

import java.util.List;

import com.gpfs.core.model.BaseEntity;

public class FSLevel2Info extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<FSLevel3Info> children;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FSLevel3Info> getChildren() {
		return children;
	}
	public void setChildren(List<FSLevel3Info> children) {
		this.children = children;
	}

}
