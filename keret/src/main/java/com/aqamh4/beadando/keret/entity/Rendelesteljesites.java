package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rendelesteljesitesek")
public class Rendelesteljesites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean teljesitett;

    @ManyToOne
    @JoinColumn(name = "rendeles_id", nullable = false)
    private Rendeles rendeles;

    public Rendelesteljesites(int id, boolean teljesitett, Rendeles rendeles) {
        this.id = id;
        this.teljesitett = teljesitett;
        this.rendeles = rendeles;
    }

    public Rendelesteljesites() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTeljesitett() {
        return teljesitett;
    }

    public void setTeljesitett(boolean teljesitett) {
        this.teljesitett = teljesitett;
    }

    public Rendeles getRendeles() {
        return rendeles;
    }

    public void setRendeles(Rendeles rendeles) {
        this.rendeles = rendeles;
    }
}
