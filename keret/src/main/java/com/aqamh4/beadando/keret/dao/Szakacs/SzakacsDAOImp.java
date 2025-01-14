package com.aqamh4.beadando.keret.dao.Szakacs;

import com.aqamh4.beadando.keret.entity.Szakacs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SzakacsDAOImp implements SzakacsDAO{


    private EntityManager entityManager;

    @Autowired
    public SzakacsDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Szakacs> findAll() {
        TypedQuery<Szakacs> query = entityManager.createQuery("from Szakacs", Szakacs.class);
        return query.getResultList();
    }

    @Override
    public Szakacs findById(int id) {
        return entityManager.find(Szakacs.class, id);
    }

    @Override
    @Transactional
    public Szakacs save(Szakacs szakacs) {
        return entityManager.merge(szakacs);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Szakacs szakacs = findById(id);
        if (szakacs != null) {
            entityManager.remove(szakacs);
        }
    }
}
