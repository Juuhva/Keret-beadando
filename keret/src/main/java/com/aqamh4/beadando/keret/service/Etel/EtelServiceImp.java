package com.aqamh4.beadando.keret.service.Etel;

import com.aqamh4.beadando.keret.dao.Etel.EtelDAO;
import com.aqamh4.beadando.keret.entity.Etel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtelServiceImp implements EtelService {

    @Autowired
    private EtelDAO etelDAO;
    @Override
    public List<Etel> findAll() {
        return etelDAO.findAll();
    }

    @Override
    public Etel findById(int id) {
        return etelDAO.findById(id);
    }

    @Override
    public Etel save(Etel etel) {
        return etelDAO.save(etel);
    }

    @Override
    public void deleteById(int id) {
        etelDAO.deleteById(id);
    }

    @Override
    public boolean update(Etel etel) {
        return etelDAO.update(etel);
    }
}
