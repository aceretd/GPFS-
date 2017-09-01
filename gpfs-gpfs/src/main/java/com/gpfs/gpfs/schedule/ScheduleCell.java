package com.gpfs.gpfs.schedule;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ScheduleCell {

	@Column(name = "content")
	private String content;

	@Column(name = "formula")
	private String formula;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

}
