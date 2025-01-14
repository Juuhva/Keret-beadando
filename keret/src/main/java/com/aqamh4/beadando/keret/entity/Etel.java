package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "etelek")
public class Etel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String etelnev;
    private String leiras;

    public int getEtelar() {
        return etelar;
    }

    public void setEtelar(int etelar) {
        this.etelar = etelar;
    }

    private int etelar;

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    @ManyToOne
    @JoinColumn(name = "szakacs_id", nullable = false)
    private Szakacs szakacs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtelnev() {
        return etelnev;
    }

    public void setEtelnev(String etelnev) {
        this.etelnev = etelnev;
    }

    public Szakacs getSzakacs() {
        return szakacs;
    }

    public void setSzakacs(Szakacs szakacs) {
        this.szakacs = szakacs;
    }

    public Etel(int id, String etelnev, int etelar, String leiras ,Szakacs szakacs) {
        this.id = id;
        this.etelnev = etelnev;
        this.etelar = etelar;
        this.leiras = leiras;
        this.szakacs = szakacs;
    }

    public Etel() {}
}
