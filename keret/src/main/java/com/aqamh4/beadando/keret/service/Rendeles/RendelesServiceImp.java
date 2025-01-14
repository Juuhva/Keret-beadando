package com.aqamh4.beadando.keret.service.Rendeles;

import com.aqamh4.beadando.keret.dao.Rendeles.RendelesDAO;
import com.aqamh4.beadando.keret.entity.Rendeles;
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
    public Rendeles save(Rendeles rendeles) {
        return rendelesDAO.save(rendeles);
    }

    @Override
    public void deleteById(int id) {
        rendelesDAO.deleteById(id);
    }
}
