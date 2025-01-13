package com.aqamh4.beadando.keret.service.Szakacs;

import com.aqamh4.beadando.keret.entity.Szakacs;

import java.util.List;

public interface SzakacsService {
    List<Szakacs> findAll();
    Szakacs findById(int id);
    Szakacs save(Szakacs szakacs);
    void deleteById(int id);
}
