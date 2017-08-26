package com.gpfs.gpfs.activation;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.gpfs.gpfs.Gpfs;
import com.gpfs.gpfs.dto.GpfsInfo;

public class ActivationConditionTest {

	@Test
	@Ignore
	public void testSpel() {
		GpfsInfo gpfs = new GpfsInfo();

		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		String name = (String) exp.getValue(gpfs);
	}

}
