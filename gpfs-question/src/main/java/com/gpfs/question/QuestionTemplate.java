package com.gpfs.question;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

/**
 * Types of questions:
 * 1. Yes or no
 * 2. User input
 * 3. Multiple choice
 * @author mbmartinez
 */
@Entity(name = "question")
public class QuestionTemplate {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "section_reference")
	private String sectionReference;

	@Column(name = "series", nullable = false, unique = true)
	private int series;

	@Column(name = "question")
	@Type(type = "text")
	private String question;

	/**
	 * If this expression evaluates to false, this question is skipped
	 */
	@Column(name = "act_condition")
	private String activationCondition;

	/**
	 * Only used by enumeration questions
	 */
	@Column(name = "max_answers")
	private int maximumAnswers = 0;

	/**
	 * Only used by MC questions
	 */
	@ElementCollection
	@CollectionTable(name = "question_mc_answers")
	private List<MultipleChoiceAnswerTemplate> answers;

	/**
	 * Not used by yes/no and MC questions
	 */
	@Column(name = "template")
	@Type(type = "text")
	private String template;

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getActivationCondition() {
		return activationCondition;
	}

	public void setActivationCondition(String activationCondition) {
		this.activationCondition = activationCondition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSectionReference() {
		return sectionReference;
	}

	public void setSectionReference(String sectionReference) {
		this.sectionReference = sectionReference;
	}

}
