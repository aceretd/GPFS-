package com.gpfs.question;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;

import com.gpfs.core.model.BaseEntity;

/**
 * Types of questions:
 * 1. Yes or no
 * 2. User input
 * 3. Multiple choice
 * @author mbmartinez
 */
@Entity(name = "question")
public class QuestionTemplate extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "section_reference")
	private String sectionReference;

	@Column(name = "note", nullable = false)
	private int note;

	/**
	 * The order in which the questions appear per note, ascending
	 */
	@Column(name = "series")
	private int series;

	@Column(name = "question")
	@Type(type = "text")
	private String question;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private QuestionType type;

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

	@Column(name = "help_text")
	@Type(type = "text")
	private String helpText;

	@Column(name = "sample_answer")
	@Type(type = "text")
	private String sampleAnswer;

	/**
	 * Not used by MC questions
	 * Used by yes/no questions when answer=yes
	 */
	@Column(name = "template")
	@Type(type = "text")
	private String template;

	/**
	 * ONly used by yes/no questions when answer=no
	 */
	@Column(name = "no_template")
	private String noTemplate;

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

	public String getSectionReference() {
		return sectionReference;
	}

	public void setSectionReference(String sectionReference) {
		this.sectionReference = sectionReference;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public int getMaximumAnswers() {
		return maximumAnswers;
	}

	public void setMaximumAnswers(int maximumAnswers) {
		this.maximumAnswers = maximumAnswers;
	}

	public List<MultipleChoiceAnswerTemplate> getAnswers() {
		return answers;
	}

	public void setAnswers(List<MultipleChoiceAnswerTemplate> answers) {
		this.answers = answers;
	}

	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getSampleAnswer() {
		return sampleAnswer;
	}

	public void setSampleAnswer(String sampleAnswer) {
		this.sampleAnswer = sampleAnswer;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public String getNoTemplate() {
		return noTemplate;
	}

	public void setNoTemplate(String noTemplate) {
		this.noTemplate = noTemplate;
	}

}
