package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "felszolgalok")
public class Felszolgalo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Felszolgalo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Felszolgalo(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;
}
