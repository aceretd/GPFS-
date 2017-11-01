package com.gpfs.company.model;

import java.time.Month;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.gpfs.core.dto.CompanyType;
import com.gpfs.core.model.BaseEntity;

@Entity(name = "company")
public class Company extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name= "company_name")
	private String name;

	@Column(name= "tin")
	private String tin;

	@Column(name = "incorporation_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime incorporationDate;

	@Column(name = "company_type")
	@Enumerated(EnumType.STRING)
	private CompanyType type;

	@Column(name = "is_group")
    @Type(type = "yes_no")
	private boolean groupOfEntities;

	@Column(name = "reporting_period_end_month")
	private Month reportingPeriodEndMonth;

	@Column(name = "reporting_period_end_day")
	private int reportingPeriodEndDay;

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
	public Month getReportingPeriodEndMonth() {
		return reportingPeriodEndMonth;
	}
	public void setReportingPeriodEndMonth(Month reportingPeriodEndMonth) {
		this.reportingPeriodEndMonth = reportingPeriodEndMonth;
	}
	public int getReportingPeriodEndDay() {
		return reportingPeriodEndDay;
	}
	public void setReportingPeriodEndDay(int reportingPeriodEndDay) {
		this.reportingPeriodEndDay = reportingPeriodEndDay;
	}

}

