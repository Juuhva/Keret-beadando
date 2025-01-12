package com.aqamh4.beadando.keret.dao;

import com.aqamh4.beadando.keret.entity.Asztal;

import java.util.List;

public interface AsztalDAO {
    List<Asztal> findAll();
    Asztal findById(int id);
    Asztal save(Asztal asztal);
    void deleteById(int id);
}
