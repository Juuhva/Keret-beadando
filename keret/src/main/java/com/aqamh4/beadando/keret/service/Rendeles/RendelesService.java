package com.aqamh4.beadando.keret.service.Rendeles;

import com.aqamh4.beadando.keret.entity.Rendeles;
import com.aqamh4.beadando.keret.entity.RendelesTetel;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RendelesService {
    List<Rendeles> findAll();
    Rendeles findById(int id);
    Rendeles save(Rendeles rendeles, List<RendelesTetel> rendelesTetelek);
    List<RendelesTetel> findOrderById(int id);
    List<Rendeles> findOrderByUserId(int userId);
    void deleteById(int id);
}
