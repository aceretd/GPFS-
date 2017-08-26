package com.gpfs.gpfs.dto;

import java.util.List;

import com.google.common.collect.Lists;
import com.gpfs.core.dto.BaseInfo;

public class NoteInfo extends BaseInfo {

	private int index;
	private List<QuestionAnswerPairInfo> questions = Lists.newArrayList();

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