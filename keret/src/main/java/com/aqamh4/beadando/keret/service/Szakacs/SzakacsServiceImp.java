package com.aqamh4.beadando.keret.service.Szakacs;

import com.aqamh4.beadando.keret.dao.Szakacs.SzakacsDAO;
import com.aqamh4.beadando.keret.entity.Szakacs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SzakacsServiceImp implements SzakacsService {

    @Autowired
    private SzakacsDAO szakacsDAO;

    @Override
    public List<Szakacs> findAll() {
        return szakacsDAO.findAll();
    }

    @Override
    public Szakacs findById(int id) {
        return szakacsDAO.findById(id);
    }

    @Override
    public Szakacs save(Szakacs szakacs) {
        return szakacsDAO.save(szakacs);
    }

    @Override
    public void deleteById(int id) {
        szakacsDAO.deleteById(id);
    }
}
