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
}
