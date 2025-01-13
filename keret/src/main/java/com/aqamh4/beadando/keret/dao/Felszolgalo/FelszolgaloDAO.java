package com.aqamh4.beadando.keret.dao.Felszolgalo;

import com.aqamh4.beadando.keret.entity.Felszolgalo;

import java.util.List;

public interface FelszolgaloDAO {
    List<Felszolgalo> findAll();
    Felszolgalo findById(int id);
    Felszolgalo save(Felszolgalo felszolgalo);
    void deleteById(int id);
}
