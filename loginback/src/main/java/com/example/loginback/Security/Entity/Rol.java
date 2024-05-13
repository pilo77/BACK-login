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
    private Long rolId;
    private String rolNombre;

    @OneToOne(mappedBy = "rol")
    private User user;



    // Otros atributos y relaciones según sea necesario
}