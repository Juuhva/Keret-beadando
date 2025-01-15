package com.aqamh4.beadando.keret.dao.Etel;

import com.aqamh4.beadando.keret.entity.Etel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class EtelDAOImp implements EtelDAO {
    private EntityManager entityManager;

    @Autowired
    public EtelDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Etel> findAll() {
        TypedQuery<Etel> query = entityManager.createQuery("from Etel", Etel.class);
        return query.getResultList();
    }

    @Override
    public Etel findById(int id) {
        return entityManager.find(Etel.class, id);
    }

    @Override
    @Transactional
    public Etel save(Etel etel) {
        return entityManager.merge(etel);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Etel etel = findById(id);
        if (etel != null) {
            entityManager.remove(etel);
        }
    }

    @Override
    @Transactional
    public boolean update(Etel etel) {
        Etel updatedEtel = entityManager.merge(etel);
        return updatedEtel != null;
    }
}