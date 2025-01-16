package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rendelesek")
public class Rendeles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date datum;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "rendeles", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RendelesTetel> rendelesTetelek;

    private int vegosszeg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RendelesTetel> getRendelesTetelek() {
        return rendelesTetelek;
    }

    public void setRendelesTetelek(List<RendelesTetel> rendelesTetelek) {
        this.rendelesTetelek = rendelesTetelek;
    }

    public int getVegosszeg() {
        return vegosszeg;
    }

    public void setVegosszeg(int vegosszeg) {
        this.vegosszeg = vegosszeg;
    }

    public Rendeles(int id, Date datum, User user, List<RendelesTetel> rendelesTetelek, int vegosszeg) {
        this.id = id;
        this.datum = datum;
        this.user = user;
        this.rendelesTetelek = rendelesTetelek;
        this.vegosszeg = vegosszeg;
    }

    public Rendeles() {
        this.datum = new Date();
    }
}
