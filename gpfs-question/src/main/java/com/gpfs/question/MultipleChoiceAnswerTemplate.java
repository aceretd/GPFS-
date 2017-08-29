package com.gpfs.question;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class MultipleChoiceAnswerTemplate extends AnswerTemplate {

	@Column(name = "answer")
	@Type(type = "text")
	private String answer;

	@Column(name = "help_text")
	@Type(type = "text")
	private String helpText;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

}
