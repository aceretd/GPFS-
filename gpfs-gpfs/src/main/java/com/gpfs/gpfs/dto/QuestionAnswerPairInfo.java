package com.gpfs.gpfs.dto;

import java.util.List;

import org.assertj.core.util.Lists;

import com.gpfs.core.dto.BaseInfo;
import com.gpfs.question.dto.QuestionTemplateInfo;

public class QuestionAnswerPairInfo extends BaseInfo {

	private QuestionTemplateInfo question;
	private String answer;
	private List<String> enumerationAnswers = Lists.newArrayList();
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
	public List<String> getEnumerationAnswers() {
		return enumerationAnswers;
	}
	public void setEnumerationAnswers(List<String> enumerationAnswers) {
		this.enumerationAnswers = enumerationAnswers;
	}

}
