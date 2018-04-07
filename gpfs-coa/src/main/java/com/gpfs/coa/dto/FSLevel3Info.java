package com.gpfs.coa.dto;

import java.util.List;
import java.util.Optional;

import com.gpfs.core.model.BaseEntity;

public class FSLevel3Info extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String series;
    private String description;
    private String name;
    private List<FSLevel4Info> children;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<FSLevel4Info> getChildren() {
        return children;
    }
    public void setChildren(List<FSLevel4Info> children) {
        this.children = children;
    }
    public FSLevel4Info getChildByAccountNumber(String accountNumber) {
        Optional<FSLevel4Info> fs4Opt = this.getChildren().stream().filter(fs4 -> accountNumber.equals(fs4.getAccountNumber())).findFirst();
        if (fs4Opt.isPresent()) {
            return fs4Opt.get();
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
