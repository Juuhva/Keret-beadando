package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asztalok")
public class Asztal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer asztal_szam;

    private Integer szekek_szama;

    private Boolean kinti_asztale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAsztal_szam() {
        return asztal_szam;
    }

    public void setAsztal_szam(Integer asztal_szam) {
        this.asztal_szam = asztal_szam;
    }

    public Integer getSzekek_szama() {
        return szekek_szama;
    }

    public void setSzekek_szama(Integer szekek_szama) {
        this.szekek_szama = szekek_szama;
    }

    public Boolean getKinti_asztale() {
        return kinti_asztale;
    }

    public void setKinti_asztale(Boolean kinti_asztale) {
        this.kinti_asztale = kinti_asztale;
    }
}
