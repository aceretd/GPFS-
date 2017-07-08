package com.gpfs.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Type;

/**
 * Types of questions:
 * 1. Yes or no
 * 2. User input
 * 3. Multiple choice
 * @author mbmartinez
 */
@Entity(name = "question")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class QuestionTemplate {

	@Id
	@GeneratedValue
	private Long id;

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

}
