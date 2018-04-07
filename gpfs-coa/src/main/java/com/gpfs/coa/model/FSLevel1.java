package com.gpfs.coa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "fs_level_1")
public class FSLevel1 extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    @Type(type = "text")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_id")
    private List<FSLevel2> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FSLevel2> getChildren() {
        return children;
    }

    public void setChildren(List<FSLevel2> children) {
        this.children = children;
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
