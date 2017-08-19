package com.gpfs.gpfs.answer;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "reconciliation_table")
public class ReconciliationTable extends ScheduleTable {

	@Column(name = "total_equity_ld")
	private BigDecimal totalEquityLastDay;

	@Column(name = "total_equity_fd")
	private BigDecimal totalEquityFirstDay;

	@Column(name = "coc_ld")
	private BigDecimal capitalizationOfCostsLastDay;

	@Column(name = "coc_fd")
	private BigDecimal capitalizationOfCostsFirstDay;

	public BigDecimal getTotalEquityLastDay() {
		return totalEquityLastDay;
	}
	public void setTotalEquityLastDay(BigDecimal totalEquityLastDay) {
		this.totalEquityLastDay = totalEquityLastDay;
	}
	public BigDecimal getTotalEquityFirstDay() {
		return totalEquityFirstDay;
	}
	public void setTotalEquityFirstDay(BigDecimal totalEquityFirstDay) {
		this.totalEquityFirstDay = totalEquityFirstDay;
	}
	public BigDecimal getCapitalizationOfCostsLastDay() {
		return capitalizationOfCostsLastDay;
	}
	public void setCapitalizationOfCostsLastDay(BigDecimal capitalizationOfCostsLastDay) {
		this.capitalizationOfCostsLastDay = capitalizationOfCostsLastDay;
	}
	public BigDecimal getCapitalizationOfCostsFirstDay() {
		return capitalizationOfCostsFirstDay;
	}
	public void setCapitalizationOfCostsFirstDay(BigDecimal capitalizationOfCostsFirstDay) {
		this.capitalizationOfCostsFirstDay = capitalizationOfCostsFirstDay;
	}

}
