package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;


@Entity
@Table(name = "szakacsok")
public class Szakacs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Szakacs() {}

    public Szakacs(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
