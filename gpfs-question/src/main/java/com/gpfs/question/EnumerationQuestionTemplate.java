package com.gpfs.question;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "question_enum")
public class EnumerationQuestionTemplate extends QuestionTemplate {

	@Column(name = "max_answers")
	private int maximumAnswers = 0;

	public int getMaximumAnswers() {
		return maximumAnswers;
	}

	public void setMaximumAnswers(int maximumAnswers) {
		this.maximumAnswers = maximumAnswers;
	}

}
