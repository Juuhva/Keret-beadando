package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rendelesek")
public class Rendeles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "etel_id", nullable = false)
    private Etel etel;

    private int vegosszeg;
    private int mennyiseg;


    public int getVegosszeg() {
        return vegosszeg;
    }

    public void setVegosszeg(int vegosszeg) {
        this.vegosszeg = vegosszeg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Etel getEtel() {
        return etel;
    }

    public void setEtel(Etel etel) {
        this.etel = etel;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }
    public Rendeles() {}

    public Rendeles(int id, User user, Etel etel, int mennyiseg, int vegosszeg) {
        this.id = id;
        this.user = user;
        this.etel = etel;
        this.mennyiseg = mennyiseg;
        this.vegosszeg = vegosszeg;
    }
}
