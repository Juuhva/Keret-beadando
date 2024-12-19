package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "etelek")
public class Etel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String etelnev;

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
}
