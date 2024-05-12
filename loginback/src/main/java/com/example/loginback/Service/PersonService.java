package com.example.loginback.Service;

import com.example.loginback.Entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();

    Optional<Person> findById(Long id);

    Person save(Person person);

    void update(Person person, Long id);

    void delete(Long id);

}
