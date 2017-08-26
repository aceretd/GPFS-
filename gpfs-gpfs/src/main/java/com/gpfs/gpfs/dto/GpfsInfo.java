package com.gpfs.gpfs.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.style.ToStringCreator;

import com.google.common.collect.Lists;
import com.gpfs.coa.dto.ChartOfAccountInfo;
import com.gpfs.core.dto.BaseInfo;
import com.gpfs.core.dto.CompanyInfo;
import com.gpfs.core.dto.schedule.ReconciliationTableInfo;
import com.gpfs.question.dto.PrincipalActivityInfo;
import com.gpfs.question.dto.QuestionTemplateInfo;

public class GpfsInfo extends BaseInfo {

	private CompanyInfo company;
	private int year;
	private ChartOfAccountInfo coa;
	private List<NoteInfo> notes = Lists.newArrayList();
	private PrincipalActivityInfo principalActivity;
	private ReconciliationTableInfo reconciliationTable;

	//Next angular state
	private String nextState;

	@Override
	public ToStringCreator toStringCreator() {
		return super.toStringCreator()
				.append("company", company);
	}

	public String answer(int series) {
		try {
			return notes.stream()
				.flatMap(n -> n.getQuestions().stream())
				.collect(Collectors.toList())
				.stream()
				.filter(qap -> qap.getQuestion().getSeries() == series)
				.findFirst()
				.get()
				.getAnswer();
		} catch (Exception e) {
			throw new IllegalArgumentException("Could not find answer to question with series=" + series);
		}
	}
	public NoteInfo note(int idx) {
		return findNote(idx).get();
	}
	public Optional<NoteInfo> findNote(int idx) {
		return notes.stream().filter(n -> n.getIndex() == idx).findFirst();
	}

	public double getPercentCompleted() {
		if (null == nextState) {
			return 0;
		}

		switch (nextState) {
		case "gpfs.update.coa":
			return 6;
		case "gpfs.update.note1":
			return 12;
		case "gpfs.update.note2":
			return 14;
		case "gpfs.update.note3":
			return 17;
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

	public List<NoteInfo> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteInfo> notes) {
		this.notes = notes;
	}

}
