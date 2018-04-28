package com.gpfs.question.dto;

public class MultipleChoiceAnswerTemplateInfo extends AnswerTemplateInfo {

    private String answer;
    private String helpText;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

}
