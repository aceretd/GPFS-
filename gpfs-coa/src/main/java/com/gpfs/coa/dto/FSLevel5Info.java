package com.gpfs.coa.dto;

import java.math.BigDecimal;

import com.gpfs.coa.model.CashflowLevel;
import com.gpfs.core.dto.BaseInfo;

public class FSLevel5Info extends BaseInfo {

    private String series;
    private String name;
    private String description;
    private BigDecimal currentYearAmount;
    private BigDecimal previousYearAmount;
    private CashflowLevel cashflowLevel;

    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }
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
