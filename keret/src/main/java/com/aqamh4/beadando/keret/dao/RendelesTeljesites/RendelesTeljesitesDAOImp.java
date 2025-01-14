package com.aqamh4.beadando.keret.dao.RendelesTeljesites;

import com.aqamh4.beadando.keret.entity.Rendelesteljesites;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RendelesTeljesitesDAOImp implements RendelesTeljesitesDAO {
    private EntityManager entityManager;

    @Autowired
    public RendelesTeljesitesDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Rendelesteljesites> findAll() {
        TypedQuery<Rendelesteljesites> query = entityManager.createQuery("from Rendelesteljesites", Rendelesteljesites.class);
        return query.getResultList();
    }

    @Override
    public Rendelesteljesites findById(int id) {
        return entityManager.find(Rendelesteljesites.class, id);
    }

    @Override
    @Transactional
    public Rendelesteljesites save(Rendelesteljesites rendelesTeljesites) {
        return entityManager.merge(rendelesTeljesites);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Rendelesteljesites rendelesTeljesites = findById(id);
        if (rendelesTeljesites != null) {
            entityManager.remove(rendelesTeljesites);
        }
    }
}
