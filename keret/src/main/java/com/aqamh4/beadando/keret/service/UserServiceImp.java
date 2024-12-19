package com.aqamh4.beadando.keret.service;

import com.aqamh4.beadando.keret.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
