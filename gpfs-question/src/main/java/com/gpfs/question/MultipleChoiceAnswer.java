package com.gpfs.question;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MultipleChoiceAnswer extends Answer {

	@Column(name = "answer")
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
