package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asztalok")
public class Asztal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer asztalSzam;

    private Integer szekekSzama;

    private Boolean kintiAsztale;

    public Asztal() {}

    public Asztal(int id, Integer asztalSzam, Integer szekekSzama, Boolean kintiAsztale) {
        this.id = id;
        this.asztalSzam = asztalSzam;
        this.szekekSzama = szekekSzama;
        this.kintiAsztale = kintiAsztale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAsztalSzam() {
        return asztalSzam;
    }

    public void setAsztalSzam(Integer asztalSzam) {
        this.asztalSzam = asztalSzam;
    }

    public Integer getSzekekSzama() {
        return szekekSzama;
    }

    public void setSzekekSzama(Integer szekekSzama) {
        this.szekekSzama = szekekSzama;
    }

    public Boolean getKintiAsztale() {
        return kintiAsztale;
    }

    public void setKintiAsztale(Boolean kintiAsztale) {
        this.kintiAsztale = kintiAsztale;
    }
}
