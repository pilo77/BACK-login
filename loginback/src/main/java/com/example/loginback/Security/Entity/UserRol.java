package com.example.loginback.Security.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Role role;
}