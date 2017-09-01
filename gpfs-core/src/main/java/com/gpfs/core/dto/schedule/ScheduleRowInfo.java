package com.gpfs.core.dto.schedule;

import java.util.List;

import com.gpfs.core.dto.BaseInfo;

public class ScheduleRowInfo extends BaseInfo {

	private List<ScheduleCellInfo> cells;

	public List<ScheduleCellInfo> getCells() {
		return cells;
	}

	public void setCells(List<ScheduleCellInfo> cells) {
		this.cells = cells;
	}
	
}
