package com.gpfs.gpfs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.gpfs.coa.model.ChartOfAccount;
import com.gpfs.company.model.Company;
import com.gpfs.core.model.BaseEntity;
import com.gpfs.gpfs.answer.ReconciliationTable;
import com.gpfs.reference.PrincipalActivity;

@Entity
@Table(
	name = "gpfs",
	uniqueConstraints = @UniqueConstraint(columnNames = {"company_id", "year"})
)
public class Gpfs extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(name = "year", nullable = false)
	private int year;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "gpfs_id")
	private List<Note> notes;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coa_id")
	private ChartOfAccount coa;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pa_id")
	private PrincipalActivity principalActivity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reconciliation_id")
	private ReconciliationTable reconciliationTable;

	@Column(name = "next_state")
	private String nextState;

	public PrincipalActivity getPrincipalActivity() {
		return principalActivity;
	}

	public void setPrincipalActivity(PrincipalActivity principalActivity) {
		this.principalActivity = principalActivity;
	}

	public ReconciliationTable getReconciliationTable() {
		return reconciliationTable;
	}

	public void setReconciliationTable(ReconciliationTable reconciliationTable) {
		this.reconciliationTable = reconciliationTable;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ChartOfAccount getCoa() {
		return coa;
	}

	public void setCoa(ChartOfAccount coa) {
		this.coa = coa;
	}

	public String getNextState() {
		return nextState;
	}

	public void setNextState(String nextState) {
		this.nextState = nextState;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
