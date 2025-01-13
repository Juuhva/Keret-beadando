package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rendelestetelek")
public class RendelesTetel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public RendelesTetel() {}

    public RendelesTetel(int id, String rendelesId, String etelId, String mennyiseg) {
        this.id = id;
        this.rendelesId = rendelesId;
        this.etelId = etelId;
        this.mennyiseg = mennyiseg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRendelesId() {
        return rendelesId;
    }

    public void setRendelesId(String rendelesId) {
        this.rendelesId = rendelesId;
    }

    public String getEtelId() {
        return etelId;
    }

    public void setEtelId(String etelId) {
        this.etelId = etelId;
    }

    public String getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(String mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    private String rendelesId;
    private String etelId;
    private String mennyiseg;
}
