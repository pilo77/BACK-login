package com.example.loginback.Security.Entity;

import com.example.loginback.Security.IRepository.RolRepository;
import com.example.loginback.Security.IRepository.UserRepository;
import com.example.loginback.Security.IRepository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RolDatabaseInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;
    private final UserRepository userRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    @Autowired
    public RolDatabaseInitializer(RolRepository rolRepository, UserRepository userRepository, UsuarioRolRepository usuarioRolRepository) {
        this.rolRepository = rolRepository;
        this.userRepository = userRepository;
        this.usuarioRolRepository = usuarioRolRepository;
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

        // Asociar el rol "ADMIN" al usuario "admin"
        Optional<User> adminUserOptional = userRepository.findByUsername("admin");
        if (adminUserOptional.isPresent()) {
            User adminUser = adminUserOptional.get();
            Optional<Rol> adminRoleOptional = rolRepository.findByNombre("ADMIN");
            adminRoleOptional.ifPresent(adminRole -> {
                UsuarioRol usuarioRol = new UsuarioRol(adminUser, adminRole);
                usuarioRolRepository.save(usuarioRol);
            });
        }
    }
}
