package com.gpfs.gpfs.dto;

import com.gpfs.core.dto.BaseInfo;
import com.gpfs.question.dto.QuestionTemplateInfo;

public class QuestionAnswerPairInfo extends BaseInfo {

	private QuestionTemplateInfo question;
	private String answer;
	private String template;
	private boolean editTemplateMode = false;

	public QuestionTemplateInfo getQuestion() {
		return question;
	}
	public void setQuestion(QuestionTemplateInfo question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public boolean isEditTemplateMode() {
		return editTemplateMode;
	}
	public void setEditTemplateMode(boolean editTemplateMode) {
		this.editTemplateMode = editTemplateMode;
	}

}
