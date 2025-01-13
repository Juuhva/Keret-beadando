package com.aqamh4.beadando.keret.dao.Felszolgalo;

import com.aqamh4.beadando.keret.entity.Felszolgalo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class FelszolgaloDAOImp implements FelszolgaloDAO {
    private EntityManager entityManager;

    @Autowired
    public FelszolgaloDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Felszolgalo> findAll() {
        TypedQuery<Felszolgalo> query = entityManager.createQuery("from Felszolgalok", Felszolgalo.class);
        return query.getResultList();
    }

    @Override
    public Felszolgalo findById(int id) {
        return entityManager.find(Felszolgalo.class, id);
    }

    @Override
    @Transactional
    public Felszolgalo save(Felszolgalo felszolgalo) {
        return entityManager.merge(felszolgalo);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Felszolgalo felszolgalo = findById(id);
        if (felszolgalo != null) {
            entityManager.remove(felszolgalo);
        }
    }
}
