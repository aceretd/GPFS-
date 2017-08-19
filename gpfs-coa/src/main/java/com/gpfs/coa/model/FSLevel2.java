package com.gpfs.coa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.gpfs.core.model.BaseEntity;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
@Entity(name = "fs_level_2")
public class FSLevel2 extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "parent_id")
	private List<FSLevel3> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FSLevel3> getChildren() {
		return children;
	}

	public void setChildren(List<FSLevel3> children) {
		this.children = children;
	}

}
