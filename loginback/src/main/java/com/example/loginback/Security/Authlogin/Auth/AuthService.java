package com.example.loginback.Security.Authlogin.Auth;


import com.example.loginback.Security.Authlogin.Jwt.JwtService;
import com.example.loginback.Security.Entity.Rol;
import com.example.loginback.Security.Entity.User;
import com.example.loginback.Security.IRepository.RolRepository;
import com.example.loginback.Security.IRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RolRepository rolRepository;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user); // El token debe contener información de rol

        // Devolver el token independientemente del rol, pero restringir acciones en otro lugar
        return AuthResponse.builder()
                .token(token)
                .build();
    }



    public AuthResponse register(RegisterRequest request) {
        // Verificar si el usuario ya existe
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso");
        }

        // Crear un nuevo usuario
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .build();

        // Recuperar el rol USER de la base de datos
        Rol userRole = rolRepository.findByNombre("USER").orElseThrow(() -> new RuntimeException("El rol USER no existe"));

        // Asignar el rol al usuario
        user.getRol().add(userRole);

        // Guardar el usuario
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}