package com.gpfs.gpfs.answer;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.gpfs.core.model.BaseEntity;
import com.gpfs.gpfs.Gpfs;
import com.gpfs.question.QuestionTemplate;

@MappedSuperclass
public abstract class Answer extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "gpfs_id")
	private Gpfs gpfs;

	@OneToOne
	@JoinColumn(name = "question_id")
	private QuestionTemplate question;

	public Gpfs getGpfs() {
		return gpfs;
	}

	public void setGpfs(Gpfs gpfs) {
		this.gpfs = gpfs;
	}

	public QuestionTemplate getQuestion() {
		return question;
	}

	public void setQuestion(QuestionTemplate question) {
		this.question = question;
	}

}
