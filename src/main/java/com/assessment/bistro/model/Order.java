package com.assessment.bistro.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "`Order`")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderId;
    private int ServerId;
    @Temporal(TemporalType.DATE)
    private LocalDate OrderDate;
    private BigDecimal SubTotal;
    private BigDecimal Tax;
    private BigDecimal Tip;
    private BigDecimal Total;

    public Order() {

    }

    public Order(int serverID, LocalDate orderDate, BigDecimal subTotal, BigDecimal tax, BigDecimal tip, BigDecimal total) {
        ServerId = serverID;
        OrderDate = orderDate;
        SubTotal = subTotal;
        Tax = tax;
        Tip = tip;
        Total = total;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getServerId() {
        return ServerId;
    }

    public void setServerId(int serverId) {
        ServerId = serverId;
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
                "OrderID=" + OrderId +
                ", ServerID=" + ServerId +
                ", OrderDate=" + OrderDate +
                ", SubTotal=" + SubTotal +
                ", Tax=" + Tax +
                ", Tip=" + Tip +
                ", Total=" + Total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderId(), order.getOrderId()) &&
                Objects.equals(getServerId(), order.getServerId()) &&
                Objects.equals(getOrderDate(), order.getOrderDate()) &&
                Objects.equals(getSubTotal(), order.getSubTotal()) &&
                Objects.equals(getTax(), order.getTax()) &&
                Objects.equals(getTip(), order.getTip()) &&
                Objects.equals(getTotal(), order.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getServerId(), getOrderDate(), getSubTotal(), getTax(), getTip(), getTotal());
    }
}
