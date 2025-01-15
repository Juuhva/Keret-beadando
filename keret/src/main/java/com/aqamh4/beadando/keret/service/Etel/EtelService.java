package com.aqamh4.beadando.keret.service.Etel;

import com.aqamh4.beadando.keret.entity.Etel;

import java.util.List;

public interface EtelService {
    List<Etel> findAll();
    Etel findById(int id);
    Etel save(Etel etel);
    void deleteById(int id);
    boolean update(Etel etel);
}
