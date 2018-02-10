package com.gpfs.question.dto;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.gpfs.core.dto.BaseInfo;
import com.gpfs.question.QuestionType;

public class QuestionTemplateInfo extends BaseInfo {

    private String sectionReference;
    private int note;
    private String question;
    private QuestionType type;
    private String activationCondition;
    private int maximumAnswers = 0;
    private List<MultipleChoiceAnswerTemplateInfo> answers;
    private String helpText;
    private String sampleAnswer;
    private String template;
    private int series;
    private boolean nextParagraph;

    @Override
    public ToStringCreator toStringCreator() {
        return super.toStringCreator()
                .append("note", note)
                .append("question", question);
    }

    public String getSectionReference() {
        return sectionReference;
    }
    public void setSectionReference(String sectionReference) {
        this.sectionReference = sectionReference;
    }
    public int getNote() {
        return note;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public QuestionType getType() {
        return type;
    }
    public void setType(QuestionType type) {
        this.type = type;
    }
    public String getActivationCondition() {
        return activationCondition;
    }
    public void setActivationCondition(String activationCondition) {
        this.activationCondition = activationCondition;
    }
    public int getMaximumAnswers() {
        return maximumAnswers;
    }
    public void setMaximumAnswers(int maximumAnswers) {
        this.maximumAnswers = maximumAnswers;
    }
    public List<MultipleChoiceAnswerTemplateInfo> getAnswers() {
        return answers;
    }
    public void setAnswers(List<MultipleChoiceAnswerTemplateInfo> answers) {
        this.answers = answers;
    }
    public String getHelpText() {
        return helpText;
    }
    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }
    public String getSampleAnswer() {
        return sampleAnswer;
    }
    public void setSampleAnswer(String sampleAnswer) {
        this.sampleAnswer = sampleAnswer;
    }
    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public boolean isNextParagraph() {
        return nextParagraph;
    }

    public void setNextParagraph(boolean nextParagraph) {
        this.nextParagraph = nextParagraph;
    }

}
