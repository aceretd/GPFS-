package com.gpfs.gpfs.activation;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.dto.NoteInfo;
import com.gpfs.gpfs.dto.QuestionAnswerPairInfo;
import com.gpfs.question.dto.QuestionTemplateInfo;

public class ActivationConditionTest {

	@Test
	public void testSpel() {
		QuestionTemplateInfo q = new QuestionTemplateInfo();
		q.setSeries(100);

		QuestionAnswerPairInfo qap = new QuestionAnswerPairInfo();
		qap.setQuestion(q);
		qap.setAnswer("Yes");

		NoteInfo note = new NoteInfo();
		note.setIndex(1);
		note.getQuestions().add(qap);

		GpfsInfo gpfs = new GpfsInfo();
		gpfs.getNotes().add(note);

		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("note(1).answer(100)=='Yes'");
		boolean isYes = (boolean) exp.getValue(gpfs);
		assertTrue(isYes);

		Expression exp2 = parser.parseExpression("note(1).answer(100)=='No'");
		boolean isNo = (boolean) exp2.getValue(gpfs);
		assertFalse(isNo);

		Expression exp3 = parser.parseExpression("answer(100)=='Yes'");
		boolean isYesAgain = (boolean) exp2.getValue(gpfs);
		assertTrue(isYes);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSpelNotFound() {
		QuestionTemplateInfo q = new QuestionTemplateInfo();
		q.setSeries(100);

		QuestionAnswerPairInfo qap = new QuestionAnswerPairInfo();
		qap.setQuestion(q);
		qap.setAnswer("Yes");

		NoteInfo note = new NoteInfo();
		note.setIndex(1);
		note.getQuestions().add(qap);

		GpfsInfo gpfs = new GpfsInfo();
		gpfs.getNotes().add(note);

		ExpressionParser parser = new SpelExpressionParser();
		Expression exp3 = parser.parseExpression("answer(200)=='Yes'");
		boolean isYesAgain = (boolean) exp3.getValue(gpfs);
	}

}
