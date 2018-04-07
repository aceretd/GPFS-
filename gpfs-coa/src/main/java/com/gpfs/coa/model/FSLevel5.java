package com.gpfs.coa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "fs_level_5")
public class FSLevel5 extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "series")
    private String series;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    @Type(type = "text")
    private String description;

    @Column(name = "curr_yr", nullable = false)
    private BigDecimal currentYearAmount;

    @Column(name = "prev_yr", nullable = false)
    private BigDecimal previousYearAmount;

    @Column(name = "cash_flow_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private CashflowLevel cashflowLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCurrentYearAmount() {
        return currentYearAmount;
    }

    public void setCurrentYearAmount(BigDecimal currentYearAmount) {
        this.currentYearAmount = currentYearAmount;
    }

    public BigDecimal getPreviousYearAmount() {
        return previousYearAmount;
    }

    public void setPreviousYearAmount(BigDecimal previousYearAmount) {
        this.previousYearAmount = previousYearAmount;
    }

    public CashflowLevel getCashflowLevel() {
        return cashflowLevel;
    }

    public void setCashflowLevel(CashflowLevel cashflowLevel) {
        this.cashflowLevel = cashflowLevel;
    }

}
