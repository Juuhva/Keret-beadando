package com.aqamh4.beadando.keret.dao;

import com.aqamh4.beadando.keret.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    private EntityManager entityManager;

    @Autowired
    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from Users", User.class);
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public User save(User user) {
        User dbUser = entityManager.merge(user);
        return dbUser;    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findById(id));

    }
}