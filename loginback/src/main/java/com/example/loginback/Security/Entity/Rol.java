package com.example.loginback.Security.Entity;


import jakarta.persistence.*;
import lombok.*;

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
    private String nombre;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UsuarioRol> usuarioRoles;
    // Otros atributos y relaciones según sea necesario
    public Rol(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.usuarioRoles = new HashSet<>();
    }
}