package com.aqamh4.beadando.keret.dao.Rendeles;

import com.aqamh4.beadando.keret.entity.Rendeles;

import java.util.List;

public interface RendelesDAO {
    List<Rendeles> findAll();
    Rendeles findById(int id);
    Rendeles save(Rendeles rendeles);
    void deleteById(int id);
}
