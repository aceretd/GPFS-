package com.gpfs.core.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

	public static String toString(BigDecimal b) {
		if (null == b) {
			return "";
		} else {
			return b.toString();
		}
	}
}
