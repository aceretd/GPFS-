package com.gpfs.coa.dto;

import static com.gpfs.core.util.XLSUtil.headerStyle;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gpfs.core.dto.BaseInfo;
import com.gpfs.core.util.BigDecimalUtil;

public class ChartOfAccountInfo extends BaseInfo {

	private List<FSLevel1Info> children;

	public List<FSLevel1Info> getChildren() {
		return children;
	}

	public void setChildren(List<FSLevel1Info> children) {
		this.children = children;
	}

	public XSSFWorkbook toWorkbook() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle headerStyle = headerStyle(workbook);
        Sheet sheet = workbook.createSheet("Chart of Account");

        int rowNum = 0;
        String[] headers = {"Code", "FS Level 1", "FS Level 2", "FS Level 3", "FS Level 4", "FS Level 5", "Client's Code", "Name",
                "CY", "PY"};
        Row secondSectionHeader = sheet.createRow(rowNum++);
        for (int index = 0; index < headers.length; index++) {
            Cell headerCell = secondSectionHeader.createCell(index);
            headerCell.setCellValue(headers[index]);
            headerCell.setCellStyle(headerStyle);
        }

        for (FSLevel1Info fs1 : getChildren()) {
        	for (FSLevel2Info fs2 : fs1.getChildren()) {
        		for (FSLevel3Info fs3 : fs2.getChildren()) {
        			for (FSLevel4Info fs4 : fs3.getChildren()) {
        				for (FSLevel5Info fs5 : fs4.getChildren()) {
        					for (FSLevel6Info fs6 : fs5.getChildren()) {
        			        	Row row = sheet.createRow(rowNum++);
        			        	int col = 0;
        			        	row.createCell(col).setCellValue(fs6.getAccountNumber());
        			        	row.createCell(++col).setCellValue(fs1.getName());
        			        	row.createCell(++col).setCellValue(fs2.getName());
        			        	row.createCell(++col).setCellValue(fs3.getName());
        			        	row.createCell(++col).setCellValue(fs4.getName());
        			        	row.createCell(++col).setCellValue(fs5.getName());
        			        	row.createCell(++col).setCellValue(fs6.getCode());
        			        	row.createCell(++col).setCellValue(fs6.getName());
        			        	row.createCell(++col).setCellValue(BigDecimalUtil.toString(fs6.getCurrentYearAmount()));
        			        	row.createCell(++col).setCellValue(BigDecimalUtil.toString(fs6.getPreviousYearAmount()));
        					}
        				}
        			}
        		}
        	}
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return workbook;
	}

}
