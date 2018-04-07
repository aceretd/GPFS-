package com.gpfs.coa.dto;

import java.util.List;
import java.util.Optional;

import com.gpfs.core.model.BaseEntity;

public class FSLevel1Info extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String series;
    private String description;
    private String name;
    private List<FSLevel2Info> children;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<FSLevel2Info> getChildren() {
        return children;
    }
    public void setChildren(List<FSLevel2Info> children) {
        this.children = children;
    }
    public FSLevel2Info getChildByName(String fs2Name) {
        Optional<FSLevel2Info> fs2Opt = this.getChildren().stream().filter(fs1 -> fs2Name.equals(fs1.getName())).findFirst();
        if (fs2Opt.isPresent()) {
            return fs2Opt.get();
        }
        return null;
    }
    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
