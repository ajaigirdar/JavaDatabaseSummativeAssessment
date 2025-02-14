package com.assessment.bistro.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "`Server`")
public class Server implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ServerID;
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

    public int getServerID() {
        return ServerID;
    }

    public void setServerID(int serverID) {
        ServerID = serverID;
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
                "ServerID=" + ServerID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", HireDate=" + HireDate +
                ", TermDate=" + TermDate +
                '}';
    }
}
