package com.gpfs.gpfs.schedule;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "gpfs_schedule_rows")
public class ScheduleRow extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ElementCollection
	@CollectionTable(name = "gpfs_schedule_cells")
	@JoinColumn(name = "schedule_row_id")
	@OrderColumn(name = "col_idx")
	private List<ScheduleCell> cells;

	public List<ScheduleCell> getCells() {
		return cells;
	}

	public void setCells(List<ScheduleCell> cells) {
		this.cells = cells;
	}


}
