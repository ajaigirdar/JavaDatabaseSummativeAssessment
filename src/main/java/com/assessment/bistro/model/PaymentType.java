package com.assessment.bistro.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Payment_Type")
public class PaymentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PaymentTypeId;
    private String PaymentTypeName;

    public PaymentType() {

    }

    public PaymentType(String paymentTypeName) {
        PaymentTypeName = paymentTypeName;
    }

    public int getPaymentTypeId() {
        return PaymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        PaymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return PaymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        PaymentTypeName = paymentTypeName;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "PaymentTypeID=" + PaymentTypeId +
                ", PaymentTypeName='" + PaymentTypeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentType that)) return false;
        return getPaymentTypeId() == that.getPaymentTypeId() && Objects.equals(getPaymentTypeName(), that.getPaymentTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentTypeId(), getPaymentTypeName());
    }
}
