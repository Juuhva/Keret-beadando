package com.aqamh4.beadando.keret.dao.Etel;

import com.aqamh4.beadando.keret.entity.Etel;

import java.util.List;

public interface EtelDAO {
    List<Etel> findAll();
    Etel findById(int id);
    Etel save(Etel etel);
    void deleteById(int id);
}
