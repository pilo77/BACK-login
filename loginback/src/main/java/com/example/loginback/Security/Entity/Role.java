package com.example.loginback.Security.Entity;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    // Otros atributos y relaciones según sea necesario
}