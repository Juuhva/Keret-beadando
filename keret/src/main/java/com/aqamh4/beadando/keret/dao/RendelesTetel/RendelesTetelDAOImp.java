package com.aqamh4.beadando.keret.dao.RendelesTetel;

import com.aqamh4.beadando.keret.entity.RendelesTetel;
import com.aqamh4.beadando.keret.entity.Rendelesteljesites;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RendelesTetelDAOImp implements RendelesTetelDAO {

    private EntityManager entityManager;


    @Autowired
    public RendelesTetelDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<RendelesTetel> findAll() {
        TypedQuery<RendelesTetel> query = entityManager.createQuery("from RendelesTetel", RendelesTetel.class);
        return query.getResultList();
    }

    @Override
    public RendelesTetel findById(int id) {
        return entityManager.find(RendelesTetel.class, id);
    }

    @Override
    @Transactional
    public RendelesTetel save(RendelesTetel rendelesTetel) {
        return entityManager.merge(rendelesTetel);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        RendelesTetel rendelesTetel = findById(id);
        if (rendelesTetel != null) {
            entityManager.remove(rendelesTetel);
        }
    }
}
