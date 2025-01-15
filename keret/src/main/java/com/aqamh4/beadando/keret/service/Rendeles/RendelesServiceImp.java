package com.aqamh4.beadando.keret.service.Rendeles;

import com.aqamh4.beadando.keret.dao.Rendeles.RendelesDAO;
import com.aqamh4.beadando.keret.entity.Rendeles;
import com.aqamh4.beadando.keret.entity.RendelesTetel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendelesServiceImp implements RendelesService {

    @Autowired
    private RendelesDAO rendelesDAO;

    @Override
    public List<Rendeles> findAll() {
        return rendelesDAO.findAll();
    }

    @Override
    public Rendeles findById(int id) {
        return rendelesDAO.findById(id);
    }

    @Override
    @Transactional
    public Rendeles save(Rendeles rendeles, List<RendelesTetel> rendelesTetelek) {
        rendeles.setRendelesTetelek(rendelesTetelek);
        rendelesTetelek.forEach(rendelesTetel -> rendelesTetel.setRendeles(rendeles));
        return rendelesDAO.save(rendeles);
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        rendelesDAO.deleteById(id);
    }
}
