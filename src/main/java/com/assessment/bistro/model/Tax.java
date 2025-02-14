package com.assessment.bistro.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Tax")
public class Tax implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TaxId;
    private BigDecimal TaxPercentage;
    @Temporal(TemporalType.DATE)
    private LocalDate StartDate;
    @Temporal(TemporalType.DATE)
    private LocalDate EndDate;

    public Tax(){

    }

    public Tax(BigDecimal taxPercentage, LocalDate startDate, LocalDate endDate) {
        TaxPercentage = taxPercentage;
        StartDate = startDate;
        EndDate = endDate;
    }

    public int getTaxId() {
        return TaxId;
    }

    public void setTaxId(int taxId) {
        TaxId = taxId;
    }

    public BigDecimal getTaxPercentage() {
        return TaxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        TaxPercentage = taxPercentage;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "TaxID=" + TaxId +
                ", TaxPercentage=" + TaxPercentage +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                '}';
    }
}
