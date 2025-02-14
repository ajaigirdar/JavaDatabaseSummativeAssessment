package com.assessment.bistro.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ItemId;
    @Column(name = "Item_Category_ID")
    private int ItemCategoryId;
    private String ItemName;
    private String ItemDescription;
    @Temporal(TemporalType.DATE)
    private LocalDate StartDate;
    @Temporal(TemporalType.DATE)
    private LocalDate EndDate;
    private BigDecimal UnitPrice;

    public Item() {

    }

    public Item(int itemCategoryId, String itemName, String itemDescription, LocalDate startDate, LocalDate endDate, BigDecimal unitPrice) {
        ItemCategoryId = itemCategoryId;
        ItemName = itemName;
        ItemDescription = itemDescription;
        StartDate = startDate;
        EndDate = endDate;
        UnitPrice = unitPrice;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getItemCategoryId() {
        return ItemCategoryId;
    }

    public void setItemCategoryId(int itemCategoryId) {
        ItemCategoryId = itemCategoryId;
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
                "ItemID=" + ItemId +
                ", ItemCategoryID=" + ItemCategoryId +
                ", ItemName='" + ItemName + '\'' +
                ", ItemDescription='" + ItemDescription + '\'' +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", UnitPrice=" + UnitPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(getItemId(), item.getItemId()) &&
                Objects.equals(getItemCategoryId(), item.getItemCategoryId()) &&
                Objects.equals(getItemName(), item.getItemName()) &&
                Objects.equals(getStartDate(), item.getStartDate()) &&
                Objects.equals(getEndDate(), item.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getItemCategoryId(), getItemName(), getStartDate(), getEndDate());

    }
}