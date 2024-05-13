package com.example.loginback.Security.Entity;

import com.example.loginback.Security.IRepository.RolRepository;
import com.example.loginback.Security.IRepository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdminInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolRepository rolRepository;

    @PostConstruct
    public void createAdminIfNotExist() {
        // Check if admin user already exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            // Create the admin user
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("strongPassword"));
            admin.setFirstname("Admin");
            admin.setLastname("Administrator");

            // Check if ADMIN role exists in the database
            Optional<Rol> adminRoleOptional = rolRepository.findByNombre("ADMIN");

            // Create or retrieve the ADMIN role
            Rol adminRole = adminRoleOptional.orElseGet(() -> {
                Rol newAdminRole = new Rol();
                newAdminRole.setNombre("ADMIN");
                return rolRepository.save(newAdminRole);
            });

            // Assign the ADMIN role to the user
            admin.getUsuarioRoles().add(new UsuarioRol(admin, adminRole));

            // Save the user
            userRepository.save(admin);
        }
    }
}