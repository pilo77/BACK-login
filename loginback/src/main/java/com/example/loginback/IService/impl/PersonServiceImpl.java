package com.example.loginback.IService.impl;


import com.example.loginback.Entity.Person;
import com.example.loginback.IRepository.PersonRepository;
import com.example.loginback.IService.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {


    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void update(Person person, Long id) {
        Optional<Person> existingPersonOptional = personRepository.findById(id);
        if (existingPersonOptional.isPresent()) {
            Person existingPerson = existingPersonOptional.get();
            existingPerson.setNombre(person.getNombre());
            existingPerson.setApellido(person.getApellido());

            // Actualiza otros campos según sea necesario
            personRepository.save(existingPerson);
        } else {
            // Manejar el caso en el que la persona no existe
            throw new RuntimeException("Persona no encontrada con id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}