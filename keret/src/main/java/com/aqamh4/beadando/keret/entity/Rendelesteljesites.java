package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rendelesteljesitesek")
public class Rendelesteljesites {

    @EmbeddedId
    private RendelesteljesitesId id;

    @ManyToOne
    @MapsId("rendeles_id")
    @JoinColumn(name = "rendeles_id")
    private Rendeles rendeles;

    @ManyToOne
    @MapsId("felszolgalo_id")
    @JoinColumn(name = "felszolgalo_id")
    private Felszolgalo felszolgalok;

    public RendelesteljesitesId getId() {
        return id;
    }

    public void setId(RendelesteljesitesId id) {
        this.id = id;
    }

    public Rendeles getRendeles() {
        return rendeles;
    }

    public void setRendeles(Rendeles rendeles) {
        this.rendeles = rendeles;
    }

    public Felszolgalo getFelszolgalok() {
        return felszolgalok;
    }

    public void setFelszolgalok(Felszolgalo felszolgalok) {
        this.felszolgalok = felszolgalok;
    }
}
