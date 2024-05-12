package com.example.loginback.dto;


import com.example.loginback.Entity.Person;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PersonDto {

    private Long id;
    @NotBlank
    private String nombre;

    private String apellido;

    private String correoElectronico;

    private String telefono;

    private String ciudad;

    private String pais;

    public Person toEntity() {
        Person person = new Person();
        person.setId(this.id);
        person.setNombre(this.nombre);
        person.setApellido(this.apellido);
        person.setCorreoElectronico(this.correoElectronico);
        person.setTelefono(this.telefono);
        person.setCiudad(this.ciudad);
        person.setPais(this.pais);
        return person;
    }
}