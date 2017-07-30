package com.gpfs.core.dto;

import org.joda.time.DateTime;

public class CompanyInfo extends BaseInfo {

	private String name;
	private String tin;
	private DateTime incorporationDate;
	private CompanyType type;
	private boolean groupOfEntities;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public DateTime getIncorporationDate() {
		return incorporationDate;
	}
	public void setIncorporationDate(DateTime incorporationDate) {
		this.incorporationDate = incorporationDate;
	}
	public CompanyType getType() {
		return type;
	}
	public void setType(CompanyType type) {
		this.type = type;
	}
	public boolean isGroupOfEntities() {
		return groupOfEntities;
	}
	public void setGroupOfEntities(boolean groupOfEntities) {
		this.groupOfEntities = groupOfEntities;
	}

}
