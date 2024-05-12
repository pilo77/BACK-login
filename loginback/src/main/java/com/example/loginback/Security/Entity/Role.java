package com.example.loginback.Security.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    // Otros atributos y relaciones según sea necesario
}