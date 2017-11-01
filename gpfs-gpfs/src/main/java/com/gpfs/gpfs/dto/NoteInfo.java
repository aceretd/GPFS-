package com.gpfs.gpfs.dto;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.google.common.collect.Lists;
import com.gpfs.core.dto.BaseInfo;

public class NoteInfo extends BaseInfo {

	private int index;
	private List<QuestionAnswerPairInfo> questions = Lists.newArrayList();

	@Override
	public ToStringCreator toStringCreator() {
		return super.toStringCreator()
				.append("index", index);
	}

	public String answer(int series) {
		return questions.stream().filter(q -> q.getQuestion().getSeries() == series).findFirst().get().getAnswer();
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<QuestionAnswerPairInfo> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionAnswerPairInfo> questions) {
		this.questions = questions;
	}

}
