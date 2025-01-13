package com.aqamh4.beadando.keret.service.User;


import com.aqamh4.beadando.keret.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    User findById(int id);
    User save(User user);
    void deleteById(int id);
}
