package com.example.loginback.Security.Entity;

import com.example.loginback.Security.IRepository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RolDatabaseInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;

    @Autowired
    public RolDatabaseInitializer(RolRepository rolRepository) {
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