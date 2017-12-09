package com.gpfs.core.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XSSFUtil {
	private static final Logger LOG = LoggerFactory.getLogger(XSSFUtil.class);
	private static final DataFormatter formatter = new DataFormatter();
	public static String getStringCellValue(Cell cell) {
		return formatter.formatCellValue(cell);
	}
	public static BigDecimal getBigDecimalCellValue(Cell cell) {
		try {
			return new BigDecimal(cell.getNumericCellValue());
		} catch (Exception e) {
			//Do nothing I guess
		}

		String val = formatter.formatCellValue(cell);
		try {
			return new BigDecimal(val).setScale(2, RoundingMode.HALF_UP);
		} catch (Exception e) {
			LOG.warn("Unable to parse value as bigdecimal! returning 0! value={}", val);
			return BigDecimal.ZERO;
		}
	}
}
