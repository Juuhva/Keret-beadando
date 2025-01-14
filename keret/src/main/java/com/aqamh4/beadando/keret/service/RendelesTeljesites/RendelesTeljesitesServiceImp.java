package com.aqamh4.beadando.keret.service.RendelesTeljesites;

import com.aqamh4.beadando.keret.dao.RendelesTeljesites.RendelesTeljesitesDAO;
import com.aqamh4.beadando.keret.entity.Rendelesteljesites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendelesTeljesitesServiceImp implements RendelesTeljesitesService {

    @Autowired
    private RendelesTeljesitesDAO rendelesTeljesitesDAO;
    @Override
    public List<Rendelesteljesites> findAll() {
        return rendelesTeljesitesDAO.findAll();
    }

    @Override
    public Rendelesteljesites findById(int id) {
        return rendelesTeljesitesDAO.findById(id);
    }

    @Override
    public Rendelesteljesites save(Rendelesteljesites rendelesTeljesites) {
        return rendelesTeljesitesDAO.save(rendelesTeljesites);
    }

    @Override
    public void deleteById(int id) {
        rendelesTeljesitesDAO.deleteById(id);
    }
}
