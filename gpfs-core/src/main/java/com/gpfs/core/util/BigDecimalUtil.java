package com.gpfs.core.util;

import java.math.BigDecimal;

import com.google.common.primitives.Ints;

public class BigDecimalUtil {

	public static String toString(BigDecimal b) {
		if (null == b) {
			return "";
		} else {
			return b.toString();
		}
	}

	public static Integer tryParse(String s) {
		Integer i = Ints.tryParse(s);
		if (null == i) {
			return 0;
		} else {
			return i;
		}
	}

}
