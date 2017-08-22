package com.gpfs.gpfs.dto;

import org.springframework.core.style.ToStringCreator;

import com.gpfs.coa.dto.ChartOfAccountInfo;
import com.gpfs.core.dto.BaseInfo;
import com.gpfs.core.dto.CompanyInfo;
import com.gpfs.core.dto.schedule.ReconciliationTableInfo;
import com.gpfs.question.dto.PrincipalActivityInfo;

public class GpfsInfo extends BaseInfo {

	private CompanyInfo company;
	private int year;
	private ChartOfAccountInfo coa;
	private PrincipalActivityInfo principalActivity;
	private ReconciliationTableInfo reconciliationTable;

	//Next angular state
	private String nextState;

	@Override
	public ToStringCreator toStringCreator() {
		return super.toStringCreator()
				.append("company", company);
	}

	public double getPercentCompleted() {
		switch (nextState) {
		case "gpfs.update.coa":
			return 6;
		case "gpfs.update.note1":
			return 12;
		default:
			return 0;
		}
	}

	public PrincipalActivityInfo getPrincipalActivity() {
		return principalActivity;
	}
	public void setPrincipalActivity(PrincipalActivityInfo principalActivity) {
		this.principalActivity = principalActivity;
	}
	public ReconciliationTableInfo getReconciliationTable() {
		return reconciliationTable;
	}
	public void setReconciliationTable(ReconciliationTableInfo reconciliationTable) {
		this.reconciliationTable = reconciliationTable;
	}

	public CompanyInfo getCompany() {
		return company;
	}

	public void setCompany(CompanyInfo company) {
		this.company = company;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ChartOfAccountInfo getCoa() {
		return coa;
	}

	public void setCoa(ChartOfAccountInfo coa) {
		this.coa = coa;
	}

	public String getNextState() {
		return nextState;
	}

	public void setNextState(String nextState) {
		this.nextState = nextState;
	}

}
