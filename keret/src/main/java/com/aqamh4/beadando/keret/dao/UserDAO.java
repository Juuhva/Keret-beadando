package com.aqamh4.beadando.keret.dao;

import com.aqamh4.beadando.keret.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findByUsername(String userName);
    User findById(int id);
    User save(User user);
    void deleteById(int id);
}
