package com.gpfs.question.dto;

import com.gpfs.core.dto.BaseInfo;

public class PrincipalActivityInfo extends BaseInfo {

	private String type;
	private String subtype;
	private String activity;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}

}
