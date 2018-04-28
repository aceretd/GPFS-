package com.gpfs.question.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.core.style.ToStringCreator;

import com.gpfs.core.dto.BaseInfo;
import com.gpfs.question.QuestionType;

public class QuestionTemplateInfo extends BaseInfo {

    @Range(min = 1, max = 100)
    private int note;

    @Range(min = 1, max = 1000000)
    private int series;

    @NotNull
    private QuestionType type;

    private String sectionReference;
    private String question;
    private String activationCondition;
    private int maximumAnswers = 0;
    private List<MultipleChoiceAnswerTemplateInfo> answers;
    private String helpText;
    private String sampleAnswer;
    private String template;
    private String noTemplate;
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

    public String getNoTemplate() {
        return noTemplate;
    }

    public void setNoTemplate(String noTemplate) {
        this.noTemplate = noTemplate;
    }

}
