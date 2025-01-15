package com.aqamh4.beadando.keret.service.RendelesTetel;

import com.aqamh4.beadando.keret.entity.RendelesTetel;
import com.aqamh4.beadando.keret.entity.Rendelesteljesites;

import java.util.List;

public interface RendelesTetelService {
    List<RendelesTetel> findAll();
    RendelesTetel findById(int id);
    RendelesTetel save(RendelesTetel rendelesTetel);
    void deleteById(int id);
}
