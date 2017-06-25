package com.gpfs.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Note 1
 * @author mbmartinez
 */
@Entity(name = "corporate_information")
public class CorporateInformation {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "reporting_date_prior_year")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime reportingDatePriorYear;

	@Column(name = "reporting_date_current_year")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime reportingDateCurrentYear;

	@Column(name = "current_year")
	private int currentYear;

	@Column(name = "prior_year")
	private int priorYear;

	@Column(name = "group_of_entities")
	@Type(type = "yes_no")
	private boolean groupOfEntities;
	
	@Column(name = "reporting_entity_a_branch")
	@Type(type = "yes_no")
	private boolean reportingEntityABranch;

	@Column(name = "incorporation_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime incorporationDate;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public DateTime getReportingDatePriorYear() {
		return reportingDatePriorYear;
	}

	public void setReportingDatePriorYear(DateTime reportingDatePriorYear) {
		this.reportingDatePriorYear = reportingDatePriorYear;
	}

	public DateTime getReportingDateCurrentYear() {
		return reportingDateCurrentYear;
	}

	public void setReportingDateCurrentYear(DateTime reportingDateCurrentYear) {
		this.reportingDateCurrentYear = reportingDateCurrentYear;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getPriorYear() {
		return priorYear;
	}

	public void setPriorYear(int priorYear) {
		this.priorYear = priorYear;
	}

	public boolean isGroupOfEntities() {
		return groupOfEntities;
	}

	public void setGroupOfEntities(boolean groupOfEntities) {
		this.groupOfEntities = groupOfEntities;
	}

	public boolean isReportingEntityABranch() {
		return reportingEntityABranch;
	}

	public void setReportingEntityABranch(boolean reportingEntityABranch) {
		this.reportingEntityABranch = reportingEntityABranch;
	}

	public DateTime getIncorporationDate() {
		return incorporationDate;
	}

	public void setIncorporationDate(DateTime incorporationDate) {
		this.incorporationDate = incorporationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
