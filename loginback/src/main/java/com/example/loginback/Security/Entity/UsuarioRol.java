

package com.example.loginback.Security.Entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User usuario;

    @ManyToOne
    private Rol rol;

    public UsuarioRol(User usuario, Rol rol) {
        this.usuario = usuario;
        this.rol = rol;
    }


    // Otros atributos y relaciones según sea necesario
}