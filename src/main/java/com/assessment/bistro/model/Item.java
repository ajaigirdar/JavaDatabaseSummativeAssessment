package com.assessment.bistro.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ItemID;
    private int ItemCategoryID;
    private String ItemName;
    private String ItemDescription;
    @Temporal(TemporalType.DATE)
    private LocalDate StartDate;
    @Temporal(TemporalType.DATE)
    private LocalDate EndDate;
    private BigDecimal UnitPrice;

    public Item() {

    }

    public Item(int itemCategoryID, String itemName, String itemDescription, LocalDate startDate, LocalDate endDate, BigDecimal unitPrice) {
        ItemCategoryID = itemCategoryID;
        ItemName = itemName;
        ItemDescription = itemDescription;
        StartDate = startDate;
        EndDate = endDate;
        UnitPrice = unitPrice;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public int getItemCategoryID() {
        return ItemCategoryID;
    }

    public void setItemCategoryID(int itemCategoryID) {
        ItemCategoryID = itemCategoryID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
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

    public BigDecimal getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        UnitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemID=" + ItemID +
                ", ItemCategoryID=" + ItemCategoryID +
                ", ItemName='" + ItemName + '\'' +
                ", ItemDescription='" + ItemDescription + '\'' +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", UnitPrice=" + UnitPrice +
                '}';
    }
}
