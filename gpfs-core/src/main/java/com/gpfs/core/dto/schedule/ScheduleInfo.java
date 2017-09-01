package com.gpfs.core.dto.schedule;

import java.util.List;

import com.gpfs.core.dto.BaseInfo;

public class ScheduleInfo extends BaseInfo  {

	private int index;
	private List<ScheduleRowInfo> rows;

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<ScheduleRowInfo> getRows() {
		return rows;
	}
	public void setRows(List<ScheduleRowInfo> rows) {
		this.rows = rows;
	} 

}
