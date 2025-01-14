package com.aqamh4.beadando.keret.service.Asztal;

import com.aqamh4.beadando.keret.dao.Asztal.AsztalDAO;
import com.aqamh4.beadando.keret.entity.Asztal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsztalServiceImp implements AsztalService{

    @Autowired
    private AsztalDAO asztalDAO;
    @Override
    public List<Asztal> findAll() {
        return asztalDAO.findAll();
    }

    @Override
    public Asztal findById(int id) {
        return asztalDAO.findById(id);
    }

    @Override
    public Asztal save(Asztal asztal) {
        return asztalDAO.save(asztal);
    }

    @Override
    public void deleteById(int id) {
        asztalDAO.deleteById(id);
    }
}
