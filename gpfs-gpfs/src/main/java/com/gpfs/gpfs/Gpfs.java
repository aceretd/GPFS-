package com.gpfs.gpfs;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.gpfs.answer.ReconciliationTable;
import com.gpfs.core.model.BaseEntity;
import com.gpfs.reference.PrincipalActivity;

@Entity(name = "gpfs")
public class Gpfs extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "pa_id")
	private PrincipalActivity principalActivity;

	@OneToOne
	@JoinColumn(name = "reconciliation_id")
	private ReconciliationTable reconciliationTable;

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

}
