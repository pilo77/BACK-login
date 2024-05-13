package com.example.loginback.Security.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.loginback.Security.Entity.Rol;
import com.example.loginback.Security.IRepository.RolRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;

    @Autowired
    public DatabaseInitializer(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verificar si los roles "USER" y "ADMIN" ya existen en la base de datos
        if (rolRepository.findByNombre("USER").isEmpty()) {
            // Si no existe, crear el rol "USER"
            Rol userRole = new Rol();
            userRole.setNombre("USER");
            rolRepository.save(userRole);
        }

        if (rolRepository.findByNombre("ADMIN").isEmpty()) {
            // Si no existe, crear el rol "ADMIN"
            Rol adminRole = new Rol();
            adminRole.setNombre("ADMIN");
            rolRepository.save(adminRole);
        }
    }
}