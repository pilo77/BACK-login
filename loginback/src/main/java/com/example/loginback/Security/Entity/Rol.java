package com.example.loginback.Security.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UserRol> usuarioRoles = new HashSet<>();

    // Otros atributos y relaciones según sea necesario
}