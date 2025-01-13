package com.aqamh4.beadando.keret.dao.Szakacs;

import com.aqamh4.beadando.keret.entity.Szakacs;

import java.util.List;

public interface SzakacsDAO {
    List<Szakacs> findAll();
    Szakacs findById(int id);
    Szakacs save(Szakacs szakacs);
    void deleteById(int id);
}
