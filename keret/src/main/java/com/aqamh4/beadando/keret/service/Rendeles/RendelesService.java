package com.aqamh4.beadando.keret.service.Rendeles;

import com.aqamh4.beadando.keret.entity.Rendeles;

import java.util.List;

public interface RendelesService {
    List<Rendeles> findAll();
    Rendeles findById(int id);
    Rendeles save(Rendeles rendeles);
    void deleteById(int id);
}
