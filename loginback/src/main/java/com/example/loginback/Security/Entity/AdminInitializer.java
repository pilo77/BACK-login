package com.example.loginback.Security.Entity;

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
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("strongPassword")) // Encriptar la contraseña
                    .firstname("Admin")
                    .lastname("Administrator")
                    .role(Role.ADMIN) // Asignar el rol ADMIN
                    .build();

            userRepository.save(admin); // Guardar el administrador
        }
    }
}