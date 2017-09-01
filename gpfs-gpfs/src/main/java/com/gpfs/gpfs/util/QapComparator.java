package com.gpfs.gpfs.util;

import java.util.Comparator;

import com.gpfs.gpfs.QuestionAnswerPair;

public class QapComparator implements Comparator<QuestionAnswerPair> {
	@Override
	public int compare(QuestionAnswerPair arg0, QuestionAnswerPair arg1) {
		return arg0.getQuestion().getSeries() - arg1.getQuestion().getSeries();
	}
}
