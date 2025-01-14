package com.aqamh4.beadando.keret.service.RendelesTetel;

import com.aqamh4.beadando.keret.dao.RendelesTetel.RendelesTetelDAO;
import com.aqamh4.beadando.keret.entity.RendelesTetel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendelesTetelServiceImp implements RendelesTetelService{

    @Autowired
    private RendelesTetelDAO rendelesTetelDAO;
    @Override
    public List<RendelesTetel> findAll() {
        return rendelesTetelDAO.findAll();
    }

    @Override
    public RendelesTetel findById(int id) {
        return rendelesTetelDAO.findById(id);
    }

    @Override
    public RendelesTetel save(RendelesTetel rendelesTetel) {
        return rendelesTetelDAO.save(rendelesTetel);
    }

    @Override
    public void deleteById(int id) {
        rendelesTetelDAO.deleteById(id);
    }
}
