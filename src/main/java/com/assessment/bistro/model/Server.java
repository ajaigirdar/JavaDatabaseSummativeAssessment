package com.assessment.bistro.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "`Server`")
public class Server implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ServerId;
    private String FirstName;
    private String LastName;
    @Temporal(TemporalType.DATE)
    private LocalDate HireDate;
    @Temporal(TemporalType.DATE)
    private LocalDate TermDate;

    public Server() {

    }

    public Server(String firstName, String lastName, LocalDate hireDate, LocalDate termDate) {
        FirstName = firstName;
        LastName = lastName;
        HireDate = hireDate;
        TermDate = termDate;
    }

    public int getServerId() {
        return ServerId;
    }

    public void setServerId(int serverId) {
        ServerId = serverId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getHireDate() {
        return HireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        HireDate = hireDate;
    }

    public LocalDate getTermDate() {
        return TermDate;
    }

    public void setTermDate(LocalDate termDate) {
        TermDate = termDate;
    }

    @Override
    public String toString() {
        return "Server{" +
                "ServerID=" + ServerId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", HireDate=" + HireDate +
                ", TermDate=" + TermDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Server server)) return false;
        return getServerId() == server.getServerId() && Objects.equals(getFirstName(), server.getFirstName()) && Objects.equals(getLastName(), server.getLastName()) && Objects.equals(getHireDate(), server.getHireDate()) && Objects.equals(getTermDate(), server.getTermDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServerId(), getFirstName(), getLastName(), getHireDate(), getTermDate());
    }
}
