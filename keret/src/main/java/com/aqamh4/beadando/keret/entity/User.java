package com.aqamh4.beadando.keret.entity;

import com.aqamh4.beadando.keret.auth.Role;
import jakarta.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
