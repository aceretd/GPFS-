package com.gpfs.coa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "fs_level_4")
public class FSLevel4 extends BaseEntity {

	private static final long serialVersionUID = 1L;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	@Type(type = "text")
	private String description;

	@Column(name = "acct_no", nullable = false)
	private String accountNumber;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "parent_id")
	private List<FSLevel5> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FSLevel5> getChildren() {
		return children;
	}

	public void setChildren(List<FSLevel5> children) {
		this.children = children;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
	
}
