package com.gpfs.render.schedule;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.primitives.Doubles;
import com.gpfs.core.dto.schedule.ScheduleInfo;
import com.gpfs.core.dto.schedule.ScheduleRowInfo;
import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.render.util.CellUtil;

@Component
public class Schedule1Renderer extends ScheduleRenderer {

	private static final Logger LOG = LoggerFactory.getLogger(Schedule1Renderer.class);
	private static final DecimalFormat NO_DECIMAL_FORMAT = new DecimalFormat("#");

	@Override
	public int getAfter() {
		return 7200;
	}

	@Override
	public int getScheduleIndex() {
		return 1;
	}

	@Override
	public void render(XWPFDocument docx, ScheduleInfo schedule, GpfsInfo gpfs) {
		List<ScheduleRowInfo> filteredAndSorted = schedule.getRows()
			.stream()
			.filter(r -> !r.getCells().get(1).equals("0") || !r.getCells().get(2).equals("0"))
			.collect(Collectors.toList());
		filteredAndSorted.sort((r1, r2) -> {
				Double a1 = Doubles.tryParse(r1.getCells().get(2).getContent());
				Double a2 = Doubles.tryParse(r2.getCells().get(2).getContent());
				int result = ObjectUtils.compare(a2, a1);
				if (result != 0) {
					return result;
				}
	
				Double b1 = Doubles.tryParse(r1.getCells().get(1).getContent());
				Double b2 = Doubles.tryParse(r2.getCells().get(1).getContent());
				return ObjectUtils.compare(b2, b1);
			});
		schedule.setRows(filteredAndSorted);

		//create table
        XWPFTable table = docx.createTable();
        //try to fix weird null pointer
//        table.getCTTbl().addNewTblGrid();
//        table.getCTTbl().addNewTblPr();
        //table.setCellMargins(0, 0, 0, 500);

        XWPFTableRow tr0 = table.getRow(0);
        getBorderedCell(tr0, 0, STBorder.SINGLE, null, null, null);
        XWPFTableCell boldDateCell1 = createBorderedCell(tr0, STBorder.SINGLE, null, null, null);
        boldDateCell1.getCTTc().getTcPr().addNewTcW().setW(BigInteger.valueOf(1500));
        
        XWPFParagraph xwpfp = boldDateCell1.getParagraphArray(0);
        if (null == xwpfp) {
        	xwpfp = boldDateCell1.addParagraph();
        	xwpfp.setAlignment(ParagraphAlignment.RIGHT);
        }
        
        XWPFRun boldDate = new CellUtil(boldDateCell1).getParagraph().createRun();
        boldDate.setBold(true);
        boldDate.setText("January 1");
        XWPFTableCell boldDateCell2 = createBorderedCell(tr0, STBorder.SINGLE, null, null, null);
        boldDateCell2.getCTTc().getTcPr().addNewTcW().setW(BigInteger.valueOf(1500));
        new CellUtil(boldDateCell2).getParagraph().setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun boldDate2 = new CellUtil(boldDateCell2).getParagraph().createRun();
        boldDate2.setBold(true);
        boldDate2.setText("December 31");

        XWPFTableRow tr1 = table.createRow();
        getBorderedCell(tr1, 0, STBorder.SINGLE, STBorder.SINGLE, STBorder.SINGLE, STBorder.SINGLE).setText("wat");
        LOG.debug("cells size={}", tr1.getTableCells().size());

        for (XWPFTableCell c : tr1.getTableCells()) {
        	initializeCell(c);
        }
        
        //        getBorderedCell(tr1, 0, null, null, STBorder.SINGLE, null);
//        XWPFParagraph p1 = new CellUtil(getBorderedCell(tr1, 1, null, null, STBorder.SINGLE, null)).getParagraph();
//        p1.setAlignment(ParagraphAlignment.RIGHT);
//        XWPFRun boldYear = p1.createRun();
//        boldYear.setBold(true);
//        boldYear.setText(String.valueOf(gpfs.getYear()));
//        XWPFParagraph p2 = new CellUtil(getBorderedCell(tr1, 2, null, null, STBorder.SINGLE, null)).getParagraph();
//        p2.setAlignment(ParagraphAlignment.RIGHT);
//        XWPFRun boldYear2 = p2.createRun();
//        boldYear2.setBold(true);
//        boldYear2.setText(String.valueOf(gpfs.getYear()));
//
//        for (int i = 0; i < schedule.getRows().size(); i++) {
//        	renderBody(schedule.getRows().get(i), table);
//        }
//
//        XWPFTableRow totals = table.createRow();
//        XWPFTableCell boldFooterCell = getBorderedCell(totals, 0, STBorder.SINGLE, null, STBorder.DOUBLE, null);
//        XWPFRun boldFooter1 = new CellUtil(boldFooterCell).getParagraph().createRun();
//        boldFooter1.setBold(true);
//        boldFooter1.setText("Total equity under PFRS for SME");
//        XWPFTableCell boldFooterCell2 = getBorderedCell(totals, 1, STBorder.SINGLE, null, STBorder.DOUBLE, null);
//        XWPFParagraph boldFooterP1 = new CellUtil(boldFooterCell2).getParagraph();
//        boldFooterP1.setAlignment(ParagraphAlignment.RIGHT);
//        XWPFRun boldFooter2 = boldFooterP1.createRun();
//        boldFooter2.setBold(true);
//        boldFooter2.setText(NO_DECIMAL_FORMAT.format(schedule.getRows().stream()
//        		.map(r -> {return Doubles.tryParse(r.getCells().get(1).getContent());})
//        		.filter(Objects::nonNull)
//        		.reduce(0d, (a, b) -> a + b)));
//        XWPFTableCell boldFooterCell3 = getBorderedCell(totals, 2, STBorder.SINGLE, null, STBorder.DOUBLE, null);
//        XWPFParagraph boldFooterP = new CellUtil(boldFooterCell3).getParagraph();
//        boldFooterP.setAlignment(ParagraphAlignment.RIGHT);
//        XWPFRun boldFooter3 = boldFooterP.createRun();
//        boldFooter3.setBold(true);
//        boldFooter3.setText(NO_DECIMAL_FORMAT.format(schedule.getRows().stream()
//        		.map(r -> {return Doubles.tryParse(r.getCells().get(2).getContent());})
//        		.filter(Objects::nonNull)
//        		.reduce(0d, (a, b) -> a + b)));
	}

	private void renderBody(ScheduleRowInfo scheduleRowInfo, XWPFTable table) {
		XWPFTableRow tr = table.createRow();
		for (int i = 0; i < scheduleRowInfo.getCells().size(); i++) {
			CellUtil cell = new CellUtil(getBorderedCell(tr, i, null, null, null, null));
			cell.getParagraph().setAlignment(i > 0 ? ParagraphAlignment.RIGHT : ParagraphAlignment.LEFT);
			cell.getCell().setText(scheduleRowInfo.getCells().get(i).getContent());
		}
	}


}
