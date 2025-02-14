package com.assessment.bistro.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "Payment_Type")
public class PaymentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PaymentTypeID;
    private String PaymentTypeName;

    public PaymentType() {

    }

    public PaymentType(String paymentTypeName) {
        PaymentTypeName = paymentTypeName;
    }

    public int getPaymentTypeID() {
        return PaymentTypeID;
    }

    public void setPaymentTypeID(int paymentTypeID) {
        PaymentTypeID = paymentTypeID;
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
                "PaymentTypeID=" + PaymentTypeID +
                ", PaymentTypeName='" + PaymentTypeName + '\'' +
                '}';
    }
}
