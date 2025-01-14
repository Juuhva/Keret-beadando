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
    @JoinColumn(name = "asztal_id", nullable = false)
    private Asztal asztal;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private LocalDate datum;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Asztal getAsztal() {
        return asztal;
    }

    public void setAsztal(Asztal asztal) {
        this.asztal = asztal;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Rendeles(int id, Asztal asztal, User user, LocalDate datum) {
        this.id = id;
        this.asztal = asztal;
        this.user = user;
        this.datum = datum;
    }

    public Rendeles() {}
}
