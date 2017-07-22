package com.gpfs.question;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity(name = "question_mc")
public class MultipleChoiceQuestionTemplate extends QuestionTemplate {

	@ElementCollection
	@CollectionTable(name = "question_mc_answers")
	private List<MultipleChoiceAnswerTemplate> answers;

	public List<MultipleChoiceAnswerTemplate> getAnswers() {
		return answers;
	}
	public void setAnswers(List<MultipleChoiceAnswerTemplate> answers) {
		this.answers = answers;
	}

}
