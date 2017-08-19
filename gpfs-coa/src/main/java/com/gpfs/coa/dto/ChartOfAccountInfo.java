package com.gpfs.coa.dto;

import java.util.List;

import com.gpfs.core.dto.BaseInfo;

public class ChartOfAccountInfo extends BaseInfo {

	private List<FSLevel1Info> children;

	public List<FSLevel1Info> getChildren() {
		return children;
	}

	public void setChildren(List<FSLevel1Info> children) {
		this.children = children;
	}

}
