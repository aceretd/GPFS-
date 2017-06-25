package com.gpfs.question;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity(name = "question_mc")
public class MultipleChoiceQuestion extends Question {

	@ElementCollection
	@CollectionTable(name = "question_mc_answers")
	private List<MultipleChoiceAnswer> answers;

	public List<MultipleChoiceAnswer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<MultipleChoiceAnswer> answers) {
		this.answers = answers;
	}

}
