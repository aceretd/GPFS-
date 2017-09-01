package com.gpfs.gpfs.schedule;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.gpfs.core.model.BaseEntity;
import com.gpfs.gpfs.Gpfs;

@Entity(name = "gpfs_sched_1")
public class Schedule1 extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne(optional = false)
    @JoinColumn(name = "gpfs_id", unique = true, nullable = false, updatable = false)
	private Gpfs gpfs;

	@Column(name = "current_reporting_period")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime currentReportingPeriod;

	@Column(name = "prior_reporting_period")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime priorReportingPeriod;

	@Column(name = "te_cy")
	private BigDecimal totalEquityCy;

	@Column(name = "te_py")
	private BigDecimal totalEquityPy;

	@Column(name = "coc_cy")
	private BigDecimal capitalizationOfCostsCy;

	@Column(name = "coc_py")
	private BigDecimal capitalizationOfCostsPy;

	@Column(name = "w_cy")
	private BigDecimal writeOffCy;

	@Column(name = "w_py")
	private BigDecimal writeOffPy;

	@Column(name = "r_cy")
	private BigDecimal reinstatementOfProvisionCy;

	@Column(name = "r_py")
	private BigDecimal reinstatementOfProvisionPy;

	@Column(name = "total_equity_final_cy")
	private BigDecimal totalEquityFinalCy;

	@Column(name = "total_equity_final_py")
	private BigDecimal totalEquityFinalPy;

	public Gpfs getGpfs() {
		return gpfs;
	}

	public void setGpfs(Gpfs gpfs) {
		this.gpfs = gpfs;
	}

	public DateTime getCurrentReportingPeriod() {
		return currentReportingPeriod;
	}

	public void setCurrentReportingPeriod(DateTime currentReportingPeriod) {
		this.currentReportingPeriod = currentReportingPeriod;
	}

	public DateTime getPriorReportingPeriod() {
		return priorReportingPeriod;
	}

	public void setPriorReportingPeriod(DateTime priorReportingPeriod) {
		this.priorReportingPeriod = priorReportingPeriod;
	}

	public BigDecimal getTotalEquityCy() {
		return totalEquityCy;
	}

	public void setTotalEquityCy(BigDecimal totalEquityCy) {
		this.totalEquityCy = totalEquityCy;
	}

	public BigDecimal getTotalEquityPy() {
		return totalEquityPy;
	}

	public void setTotalEquityPy(BigDecimal totalEquityPy) {
		this.totalEquityPy = totalEquityPy;
	}

	public BigDecimal getCapitalizationOfCostsCy() {
		return capitalizationOfCostsCy;
	}

	public void setCapitalizationOfCostsCy(BigDecimal capitalizationOfCostsCy) {
		this.capitalizationOfCostsCy = capitalizationOfCostsCy;
	}

	public BigDecimal getCapitalizationOfCostsPy() {
		return capitalizationOfCostsPy;
	}

	public void setCapitalizationOfCostsPy(BigDecimal capitalizationOfCostsPy) {
		this.capitalizationOfCostsPy = capitalizationOfCostsPy;
	}

	public BigDecimal getWriteOffCy() {
		return writeOffCy;
	}

	public void setWriteOffCy(BigDecimal writeOffCy) {
		this.writeOffCy = writeOffCy;
	}

	public BigDecimal getWriteOffPy() {
		return writeOffPy;
	}

	public void setWriteOffPy(BigDecimal writeOffPy) {
		this.writeOffPy = writeOffPy;
	}

	public BigDecimal getReinstatementOfProvisionCy() {
		return reinstatementOfProvisionCy;
	}

	public void setReinstatementOfProvisionCy(BigDecimal reinstatementOfProvisionCy) {
		this.reinstatementOfProvisionCy = reinstatementOfProvisionCy;
	}

	public BigDecimal getReinstatementOfProvisionPy() {
		return reinstatementOfProvisionPy;
	}

	public void setReinstatementOfProvisionPy(BigDecimal reinstatementOfProvisionPy) {
		this.reinstatementOfProvisionPy = reinstatementOfProvisionPy;
	}

	public BigDecimal getTotalEquityFinalCy() {
		return totalEquityFinalCy;
	}

	public void setTotalEquityFinalCy(BigDecimal totalEquityFinalCy) {
		this.totalEquityFinalCy = totalEquityFinalCy;
	}

	public BigDecimal getTotalEquityFinalPy() {
		return totalEquityFinalPy;
	}

	public void setTotalEquityFinalPy(BigDecimal totalEquityFinalPy) {
		this.totalEquityFinalPy = totalEquityFinalPy;
	}

}
