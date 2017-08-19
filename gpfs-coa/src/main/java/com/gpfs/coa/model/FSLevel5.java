package com.gpfs.coa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "fs_level_5")
public class FSLevel5 extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "acct_no", nullable = false)
	private String accountNumber;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private FSLevel4 parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<FSLevel6> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FSLevel4 getParent() {
		return parent;
	}

	public void setParent(FSLevel4 parent) {
		this.parent = parent;
	}
	
}
