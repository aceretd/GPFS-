package com.gpfs.coa.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.style.ToStringCreator;

import com.gpfs.core.dto.BaseInfo;

public class ChartOfAccountInfo extends BaseInfo {

	private static final Logger LOG = LoggerFactory.getLogger(ChartOfAccountInfo.class);

	private List<FSLevel1Info> children;

	public ChartOfAccountInfo() {
		//No arg constructor
	}

	@Override
	public ToStringCreator toStringCreator() {
		return new ToStringCreator(this)
				.append("fs1s", children);
	}

	public XSSFWorkbook toWorkbook() {
        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFCellStyle headerStyle = headerStyle(workbook);
//        Sheet sheet = workbook.createSheet("Chart of Account");
//
//        int rowNum = 0;
//        String[] headers = {"Series", "FS 4 Series", "FS Level 5 Series", "FS Level 6 Series", "FS Level 1",
//        		"FS Level 2", "FS Level 3", "FS Level 4", "FS Level 5", "Client's Code", "Name",
//                "CY", "PY"};
//        Row secondSectionHeader = sheet.createRow(rowNum++);
//        for (int index = 0; index < headers.length; index++) {
//            Cell headerCell = secondSectionHeader.createCell(index);
//            headerCell.setCellValue(headers[index]);
//            headerCell.setCellStyle(headerStyle);
//        }
//
//        for (FSLevel1Info fs1 : getChildren()) {
//        	for (FSLevel2Info fs2 : fs1.getChildren()) {
//        		for (FSLevel3Info fs3 : fs2.getChildren()) {
//        			for (FSLevel4Info fs4 : fs3.getChildren()) {
//        				for (FSLevel5Info fs5 : fs4.getChildren()) {
//        					for (FSLevel6Info fs6 : fs5.getChildren()) {
//        			        	Row row = sheet.createRow(rowNum++);
//        			        	int col = 0;
//
//        			        	Integer fs4Int = tryParse(fs4.getAccountNumber());
//        			        	Integer fs5Int = tryParse(fs5.getAccountNumber());
//        			        	Integer fs6Int = tryParse(fs6.getAccountNumber());
//
//        			        	row.createCell(col).setCellValue(fs4Int + fs5Int + fs6Int);
//        			        	row.createCell(++col).setCellValue(fs4.getAccountNumber());
//        			        	row.createCell(++col).setCellValue(fs5.getAccountNumber());
//        			        	row.createCell(++col).setCellValue(fs6.getAccountNumber());
//        			        	row.createCell(++col).setCellValue(fs1.getName());
//        			        	row.createCell(++col).setCellValue(fs2.getName());
//        			        	row.createCell(++col).setCellValue(fs3.getName());
//        			        	row.createCell(++col).setCellValue(fs4.getName());
//        			        	row.createCell(++col).setCellValue(fs5.getName());
//        			        	row.createCell(++col).setCellValue(fs6.getCode());
//        			        	row.createCell(++col).setCellValue(fs6.getName());
//        			        	row.createCell(++col).setCellValue(BigDecimalUtil.toString(fs6.getCurrentYearAmount()));
//        			        	row.createCell(++col).setCellValue(BigDecimalUtil.toString(fs6.getPreviousYearAmount()));
//        					}
//        				}
//        			}
//        		}
//        	}
//        }
//
//        for (int i = 0; i < headers.length; i++) {
//            sheet.autoSizeColumn(i);
//        }

        return workbook;
	}

	public static ChartOfAccountInfo fromWorkbook(ChartOfAccountInfo existing, XSSFWorkbook workbook) {
		
		Sheet sheet = workbook.getSheetAt(0);
//		int fs6NameCol = CellReference.convertColStringToIndex("K");
//		int fs6Cy = CellReference.convertColStringToIndex("L");
//		int fs6Py = CellReference.convertColStringToIndex("M");

//		List<String> activeAccountNumbers = Lists.newArrayList();
//		for (Row row : sheet) {
//			int rowNum = row.getRowNum();
//			LOG.debug("Processing row. rownum={}", rowNum);
//			if (rowNum == 0) {
//				//skip header row
//				continue;
//			}
//
//			int col = 0;
//			String accountNumber = getStringCellValue(row.getCell(col)).trim();
//			String fs4Series = getStringCellValue(row.getCell(++col)).trim();
//			String fs5Series = getStringCellValue(row.getCell(++col)).trim();
//			String fs6Series = getStringCellValue(row.getCell(++col)).trim();
//			String fs1Name = getStringCellValue(row.getCell(++col)).trim();
//			String fs2Name = getStringCellValue(row.getCell(++col)).trim();
//			String fs3Name = getStringCellValue(row.getCell(++col)).trim();
//			String fs4Name = getStringCellValue(row.getCell(++col)).trim();
//			String fs5Name = getStringCellValue(row.getCell(++col)).trim();
//			String fs6Code = getStringCellValue(row.getCell(++col)).trim();
//			String fs6Name = getStringCellValue(row.getCell(++col)).trim();
//			BigDecimal cy = getBigDecimalCellValue(row.getCell(++col));
//			BigDecimal py = getBigDecimalCellValue(row.getCell(++col));
//
//			if (cy.compareTo(BigDecimal.ZERO) == 0 && py.compareTo(BigDecimal.ZERO) == 0) {
//				//Skip blank/0 value cells
//				continue;
//			}
//			activeAccountNumbers.add(accountNumber);
//
//			FSLevel1Info fs1 = existing.getChildByName(fs1Name);
//			if (null == fs1) {
//				throw new IllegalArgumentException("Invalid FS LEVEL 1 NAME! row=" + rowNum + ", name=" + fs1Name);
//			}
//			FSLevel2Info fs2 = fs1.getChildByName(fs2Name);
//			if (null == fs2) {
//				throw new IllegalArgumentException("Invalid FS LEVEL 2 NAME! row=" + rowNum + ", name=" + fs2Name);
//			}
//			FSLevel3Info fs3 = fs2.getChildByName(fs3Name);
//			if (null == fs3) {
//				throw new IllegalArgumentException("Invalid FS LEVEL 3 NAME! row=" + rowNum + ", name=" + fs3Name);
//			}
//			FSLevel4Info fs4 = fs3.getChildByAccountNumber(fs4Series);
//			if (null == fs4) {
//				fs4 = new FSLevel4Info();
//				fs4.setAccountNumber(fs4Series);
//				fs4.setName(fs4Name);
//				fs3.getChildren().add(fs4);
//			}
//			FSLevel5Info fs5 = fs4.getChildByAccountNumber(fs5Series);
//			if (null == fs5) {
//				fs5 = new FSLevel5Info();
//				fs5.setAccountNumber(fs5Series);
//				fs5.setName(fs4Name);
//				fs4.getChildren().add(fs5);
//			}
//			FSLevel6Info fs6 = fs5.getChildByAccountNumber(fs6Series);
//			if (null == fs6) {
//				fs6 = new FSLevel6Info();
//				fs6.setAccountNumber(fs6Series);
//				fs6.setName(fs6Name);
//				fs5.getChildren().add(fs6);
//			}
//			fs6.setCode(fs6Code);
//			fs6.setName(fs6Name);
//			fs6.setCurrentYearAmount(cy);
//			fs6.setPreviousYearAmount(py);
//			fs6.setFullAccountNumber(accountNumber);
//
//			LOG.debug("Successfully created fs6. fs6={}", fs6);
//		}
//
//		//delete inactives
//		LOG.debug("Will try to remove inactives. active codes={}", activeAccountNumbers);
//		List<FSLevel5Info> allLevel5s = existing.getChildren().stream()
//			.flatMap(fs1List -> fs1List.getChildren().stream())
//			.flatMap(fs2List -> fs2List.getChildren().stream())
//			.flatMap(fs3List -> fs3List.getChildren().stream())
//			.flatMap(fs4List -> fs4List.getChildren().stream())
//			.collect(Collectors.toList());
//		for (FSLevel5Info fs5 : allLevel5s) {
//			for (Iterator<FSLevel6Info> iterator = fs5.getChildren().iterator(); iterator.hasNext();) {
//				FSLevel6Info fs6 = iterator.next();
//				if (!activeAccountNumbers.contains(fs6.getFullAccountNumber())) {
//					iterator.remove();
//				}
//			}
//		}
//
//		LOG.debug("Remaining fs6s={}", allLevel5s.stream().flatMap(fs5List -> fs5List.getChildren().stream()).collect(Collectors.toList()));

		return existing;
	}

	private FSLevel1Info getChildByName(String fs1Name) {
		LOG.debug("Trying to find child by name. name={}, children names={}", fs1Name, children.stream().map(FSLevel1Info::getName).collect(Collectors.toList()));
		Optional<FSLevel1Info> fs1Opt = this.getChildren().stream().filter(fs1 -> fs1Name.equals(fs1.getName())).findFirst();
		if (fs1Opt.isPresent()) {
			return fs1Opt.get();
		}
		return null;
	}

	public List<FSLevel1Info> getChildren() {
		return children;
	}

	public void setChildren(List<FSLevel1Info> children) {
		this.children = children;
	}
}
