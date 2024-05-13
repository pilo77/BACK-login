package com.example.loginback.Security.Entity;

import com.example.loginback.Security.IRepository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AdminInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdminIfNotExist() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            // Crear el usuario
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("strongPassword")); // Encriptar la contraseña
            admin.setFirstname("Admin");
            admin.setLastname("Administrator");

            Rol adminRol = new Rol();
            adminRol.setNombre("ADMIN");

            // Asignar el rol al usuario
            admin.getRol().add(adminRol);

            // Guardar el usuario
            userRepository.save(admin);

        }
    }
}