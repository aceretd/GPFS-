package com.gpfs.coa.dto;

import java.util.List;

import com.gpfs.core.model.BaseEntity;

public class FSLevel1Info extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<FSLevel2Info> children;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FSLevel2Info> getChildren() {
		return children;
	}
	public void setChildren(List<FSLevel2Info> children) {
		this.children = children;
	}

}
