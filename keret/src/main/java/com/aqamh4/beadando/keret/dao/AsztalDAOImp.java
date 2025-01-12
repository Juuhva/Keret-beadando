package com.aqamh4.beadando.keret.dao;

import com.aqamh4.beadando.keret.entity.Asztal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AsztalDAOImp implements AsztalDAO{

    private EntityManager entityManager;

    @Autowired
    public AsztalDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Asztal> findAll() {
        TypedQuery<Asztal> query = entityManager.createQuery("from asztalok", Asztal.class);
        return query.getResultList();
    }

    @Override
    public Asztal findById(int id) {
        return entityManager.find(Asztal.class, id);
    }

    @Override
    @Transactional
    public Asztal save(Asztal asztal) {
        Asztal dbAsztal = entityManager.merge(asztal);
        return dbAsztal;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}