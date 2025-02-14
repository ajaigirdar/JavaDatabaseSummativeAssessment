package com.assessment.bistro.model;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "`Order`")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;
    private int ServerID;
    @Temporal(TemporalType.DATE)
    private LocalDate OrderDate;
    private BigDecimal SubTotal;
    private BigDecimal Tax;
    private BigDecimal Tip;
    private BigDecimal Total;

    public Order() {

    }

    public Order(int serverID, LocalDate orderDate, BigDecimal subTotal, BigDecimal tax, BigDecimal tip, BigDecimal total) {
        ServerID = serverID;
        OrderDate = orderDate;
        SubTotal = subTotal;
        Tax = tax;
        Tip = tip;
        Total = total;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getServerID() {
        return ServerID;
    }

    public void setServerID(int serverID) {
        ServerID = serverID;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        OrderDate = orderDate;
    }

    public BigDecimal getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        SubTotal = subTotal;
    }

    public BigDecimal getTax() {
        return Tax;
    }

    public void setTax(BigDecimal tax) {
        Tax = tax;
    }

    public BigDecimal getTip() {
        return Tip;
    }

    public void setTip(BigDecimal tip) {
        Tip = tip;
    }

    public BigDecimal getTotal() {
        return Total;
    }

    public void setTotal(BigDecimal total) {
        Total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID=" + OrderID +
                ", ServerID=" + ServerID +
                ", OrderDate=" + OrderDate +
                ", SubTotal=" + SubTotal +
                ", Tax=" + Tax +
                ", Tip=" + Tip +
                ", Total=" + Total +
                '}';
    }
}
