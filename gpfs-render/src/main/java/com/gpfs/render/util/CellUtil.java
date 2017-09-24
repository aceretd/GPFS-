package com.gpfs.render.util;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;

public class CellUtil {

	XWPFTableCell cell;

	public CellUtil(XWPFTableCell cell) {
		this.cell = cell;
	}

	public XWPFParagraph getParagraph() {
		XWPFParagraph xwpfp = cell.getParagraphArray(0);
		if (null == xwpfp) {
			xwpfp = cell.addParagraph();
		}
		return xwpfp;
	}

	public XWPFTableCell  getCell() {
		return cell;
	}

}
