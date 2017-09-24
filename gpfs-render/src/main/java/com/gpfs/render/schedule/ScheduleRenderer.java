package com.gpfs.render.schedule;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

import com.gpfs.core.dto.schedule.ScheduleInfo;
import com.gpfs.core.dto.schedule.ScheduleRowInfo;
import com.gpfs.gpfs.dto.GpfsInfo;

public abstract class ScheduleRenderer {

	public abstract int getAfter();
	public abstract int getScheduleIndex();

	
	public void render(XWPFDocument docx, ScheduleInfo schedule, GpfsInfo gpfs) {
		// TODO Auto-generated method stub
	}

	protected void simpleRender(ScheduleRowInfo scheduleRowInfo, XWPFTable table) {
		XWPFTableRow tr = table.createRow();
		for (int i = 0; i < scheduleRowInfo.getCells().size(); i++) {
			XWPFTableCell cell = getBorderedCell(tr, i, null, null, null, null);
			cell.setText(scheduleRowInfo.getCells().get(i).getContent());
		}
	}

	protected XWPFTableCell createBorderedCell(XWPFTableRow tr0, STBorder.Enum top, STBorder.Enum right, STBorder.Enum bottom, STBorder.Enum left) {
		return createOrGetBorderedCell(tr0, -1, top, right, bottom, left);
	}

	protected XWPFTableCell getBorderedCell(XWPFTableRow tr0, int col, STBorder.Enum top, STBorder.Enum right, STBorder.Enum bottom, STBorder.Enum left) {
		return createOrGetBorderedCell(tr0, col, top, right, bottom, left);
	}

	protected XWPFTableCell createOrGetBorderedCell(XWPFTableRow tr0, int col, STBorder.Enum top, STBorder.Enum right, STBorder.Enum bottom, STBorder.Enum left) {
		XWPFTableCell cell = col == -1 ? tr0.createCell() : tr0.getCell(col);

		CTTc ctTc = cell.getCTTc();
		CTTcPr tcPr = ctTc.addNewTcPr();
		CTTcBorders border = tcPr.addNewTcBorders();

		border.addNewTop().setVal(top == null ? STBorder.NIL : top);
		border.addNewRight().setVal(right == null ? STBorder.NIL : right);
		border.addNewBottom().setVal(bottom == null ? STBorder.NIL : bottom);
		border.addNewLeft().setVal(left == null ? STBorder.NIL : left);

		return cell;
	}
}
