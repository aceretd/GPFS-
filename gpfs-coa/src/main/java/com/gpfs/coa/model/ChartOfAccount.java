package com.gpfs.coa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "chart_of_account")
public class ChartOfAccount extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "coa_id")
	private List<FSLevel1> children;

	public List<FSLevel1> getChildren() {
		return children;
	}

	public void setChildren(List<FSLevel1> children) {
		this.children = children;
	}

}
