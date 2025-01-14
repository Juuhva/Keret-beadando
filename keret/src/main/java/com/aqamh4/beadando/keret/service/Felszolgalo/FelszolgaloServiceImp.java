package com.aqamh4.beadando.keret.service.Felszolgalo;

import com.aqamh4.beadando.keret.dao.Felszolgalo.FelszolgaloDAO;
import com.aqamh4.beadando.keret.entity.Felszolgalo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FelszolgaloServiceImp implements FelszolgaloService {

    @Autowired
    private FelszolgaloDAO felszolgaloDAO;

    @Override
    public List<Felszolgalo> findAll() {
        return felszolgaloDAO.findAll();
    }

    @Override
    public Felszolgalo findById(int id) {
        return felszolgaloDAO.findById(id);
    }

    @Override
    public Felszolgalo save(Felszolgalo felszolgalo) {
        return felszolgaloDAO.save(felszolgalo);
    }

    @Override
    public void deleteById(int id) {
        felszolgaloDAO.deleteById(id);
    }
}
