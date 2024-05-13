package com.example.loginback.Security.Entity;


import jakarta.persistence.*;
import lombok.*;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    private Long id;
    private String nombre;

    @OneToOne(mappedBy = "rol")
    private User user;



    // Otros atributos y relaciones según sea necesario
}