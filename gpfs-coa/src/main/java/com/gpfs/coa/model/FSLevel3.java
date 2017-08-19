package com.gpfs.coa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "fs_level_3")
public class FSLevel3 extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private FSLevel2 parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<FSLevel4> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FSLevel2 getParent() {
		return parent;
	}

	public void setParent(FSLevel2 parent) {
		this.parent = parent;
	}

	public List<FSLevel4> getChildren() {
		return children;
	}

	public void setChildren(List<FSLevel4> children) {
		this.children = children;
	}

}
