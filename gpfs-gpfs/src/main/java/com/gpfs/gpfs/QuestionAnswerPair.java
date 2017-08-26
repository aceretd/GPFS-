package com.gpfs.gpfs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.gpfs.core.model.BaseEntity;
import com.gpfs.question.QuestionTemplate;

@Entity(name = "question_answer_pair")
public class QuestionAnswerPair extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private QuestionTemplate question;

	@Column(name = "answer")
	private String answer;

	@Column(name = "template")
	@Type(type = "text")
	private String template;

	@Column(name = "edit_template_mode")
	@Type(type = "yes_no")
	private boolean editTemplateMode = false;

	public QuestionTemplate getQuestion() {
		return question;
	}

	public void setQuestion(QuestionTemplate question) {
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
