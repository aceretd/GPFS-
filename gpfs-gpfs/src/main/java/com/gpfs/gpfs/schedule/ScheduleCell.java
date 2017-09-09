package com.gpfs.gpfs.schedule;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ScheduleCell {

	@Column(name = "content")
	private String content;

	@Column(name = "formula")
	private String formula;

	@Column(name = "comment")
	private String comment;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
