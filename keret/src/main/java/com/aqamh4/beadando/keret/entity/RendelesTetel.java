package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "rendelestetelek")
public class RendelesTetel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rendeles_id", nullable = false)
    private Rendeles rendeles;

    @ManyToOne
    @JoinColumn(name = "etel_id", nullable = false)
    private Etel etel;

    private int mennyiseg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rendeles getRendeles() {
        return rendeles;
    }

    public void setRendeles(Rendeles rendeles) {
        this.rendeles = rendeles;
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

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    private int vegosszeg;

    public int getVegosszeg() {
        return vegosszeg;
    }

    public void setVegosszeg(int vegosszeg) {
        this.vegosszeg = vegosszeg;
    }

    public RendelesTetel(int id, Rendeles rendeles, Etel etel, int mennyiseg, int vegosszeg) {
        this.id = id;
        this.rendeles = rendeles;
        this.etel = etel;
        this.mennyiseg = mennyiseg;
        this.vegosszeg = vegosszeg;
    }

    public RendelesTetel() {}
}
