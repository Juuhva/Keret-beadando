package com.aqamh4.beadando.keret.service.Asztal;

import com.aqamh4.beadando.keret.entity.Asztal;

import java.util.List;

public interface AsztalService {
    List<Asztal> findAll();
    Asztal findById(int id);
    Asztal save(Asztal asztal);
    void deleteById(int id);
}
