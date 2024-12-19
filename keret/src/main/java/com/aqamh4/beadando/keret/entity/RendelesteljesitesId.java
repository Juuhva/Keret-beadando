package com.aqamh4.beadando.keret.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RendelesteljesitesId implements Serializable {
    private int rendeles_id;
    private int felszolgalo_id;

    public RendelesteljesitesId() {}

    public RendelesteljesitesId(int rendeles_id, int felszolgalo_id) {
        this.rendeles_id = rendeles_id;
        this.felszolgalo_id = felszolgalo_id;
    }

    public int getRendeles_id() {
        return rendeles_id;
    }

    public void setRendeles_id(int rendeles_id) {
        this.rendeles_id = rendeles_id;
    }

    public int getFelszolgalok_id() {
        return felszolgalo_id;
    }

    public void setFelszolgalok_id(int felszolgalok_id) {
        this.felszolgalo_id = felszolgalok_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendelesteljesitesId that = (RendelesteljesitesId) o;
        return Objects.equals(rendeles_id, that.rendeles_id) &&
                Objects.equals(felszolgalo_id, that.felszolgalo_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rendeles_id, felszolgalo_id);
    }
}

