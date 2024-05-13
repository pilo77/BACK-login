package com.example.loginback.Security.Authlogin.Auth;

import com.example.loginback.Security.Authlogin.Auth.AuthResponse;
import com.example.loginback.Security.Authlogin.Auth.LoginRequest;
import com.example.loginback.Security.Authlogin.Auth.RegisterRequest;
import com.example.loginback.Security.Authlogin.Jwt.JwtService;
import com.example.loginback.Security.Entity.Rol;
import com.example.loginback.Security.Entity.User;
import com.example.loginback.Security.Entity.UsuarioRol;
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

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));

        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso");
        }

        User user = createUserFromRequest(request);
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    private User createUserFromRequest(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setCountry(request.getCountry());

        // Asignar el rol "USER" al usuario
        Rol userRole = rolRepository.findByRolNombre("USER")
                .orElseThrow(() -> new RuntimeException("El rol USER no existe"));
        user.setUsuarioRoles(Set.of(new UsuarioRol(user, userRole)));

        return user;
    }

    // Otros métodos del servicio...
}