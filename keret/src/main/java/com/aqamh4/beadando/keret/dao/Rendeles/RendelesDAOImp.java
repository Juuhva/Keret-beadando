package com.aqamh4.beadando.keret.dao.Rendeles;

import com.aqamh4.beadando.keret.entity.Rendeles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class RendelesDAOImp implements RendelesDAO {
    private EntityManager entityManager;

    @Autowired
    public RendelesDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Rendeles> findAll() {
        TypedQuery<Rendeles> query = entityManager.createQuery("from Rendeles", Rendeles.class);
        return query.getResultList();
    }

    @Override
    public Rendeles findById(int id) {
        return entityManager.find(Rendeles.class, id);
    }

    @Override
    @Transactional
    public Rendeles save(Rendeles rendeles) {
        return entityManager.merge(rendeles);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Rendeles rendeles = findById(id);
        if (rendeles != null) {
            entityManager.remove(rendeles);
        }
    }
}
