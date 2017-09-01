package com.gpfs.gpfs.schedule;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "gpfs_schedule")
public class Schedule extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "schedule_index", nullable = false)
	private int index;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule_id")
	@OrderColumn(name = "row_idx")
	private List<ScheduleRow> rows; 

	public List<ScheduleRow> getRows() {
		return rows;
	}

	public void setRows(List<ScheduleRow> rows) {
		this.rows = rows;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
