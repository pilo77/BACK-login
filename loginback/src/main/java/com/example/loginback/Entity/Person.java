package com.example.loginback.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String genero;

    @Column(unique = true)
    private String correoElectronico;

    private String telefono;

    private String direccion;

    private String ciudad;

    private String pais;

}