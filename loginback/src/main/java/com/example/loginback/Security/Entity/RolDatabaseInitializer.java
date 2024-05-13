package com.example.loginback.Security.Entity;

import com.example.loginback.Security.IRepository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolDatabaseInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verificar si el rol "USER" ya existe en la base de datos
        if (rolRepository.findByRolNombre("USER").isEmpty()) {
            // Si no existe, crear el rol "USER"
            Rol userRole = new Rol();
            userRole.setRolNombre("USER");
            rolRepository.save(userRole);
        }
    }
}