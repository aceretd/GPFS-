package com.gpfs.coa.dto;

import java.util.List;

import com.google.common.collect.Lists;
import com.gpfs.core.model.BaseEntity;

public class FSLevel4Info extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String series;
    private String description;
    private String name;
    private String accountNumber;
    private List<FSLevel5Info> children = Lists.newArrayList();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<FSLevel5Info> getChildren() {
        return children;
    }
    public void setChildren(List<FSLevel5Info> children) {
        this.children = children;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
