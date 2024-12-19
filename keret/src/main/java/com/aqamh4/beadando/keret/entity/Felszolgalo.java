package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "felszolgalok")
public class Felszolgalo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nev;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
}
