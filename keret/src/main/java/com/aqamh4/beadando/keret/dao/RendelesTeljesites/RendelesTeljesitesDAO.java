package com.aqamh4.beadando.keret.dao.RendelesTeljesites;

import com.aqamh4.beadando.keret.entity.Rendelesteljesites;

import java.util.List;

public interface RendelesTeljesitesDAO {
    List<Rendelesteljesites> findAll();
    Rendelesteljesites findById(int id);
    Rendelesteljesites save(Rendelesteljesites rendelesTeljesites);
    void deleteById(int id);
}
