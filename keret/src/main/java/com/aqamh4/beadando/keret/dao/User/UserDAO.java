package com.aqamh4.beadando.keret.dao.User;

import com.aqamh4.beadando.keret.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(int id);
    User save(User user);
    User findByUsername(String username);
    void deleteById(int id);
}
