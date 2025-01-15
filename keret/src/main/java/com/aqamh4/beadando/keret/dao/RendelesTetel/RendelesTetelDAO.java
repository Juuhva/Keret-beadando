package com.aqamh4.beadando.keret.dao.RendelesTetel;

import com.aqamh4.beadando.keret.entity.RendelesTetel;
import com.aqamh4.beadando.keret.entity.Rendelesteljesites;

import java.util.List;

public interface RendelesTetelDAO {
    List<RendelesTetel> findAll();
    RendelesTetel findById(int id);
    RendelesTetel save(RendelesTetel rendelesTetel);
    void deleteById(int id);
}
