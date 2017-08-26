package com.gpfs.gpfs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

}
