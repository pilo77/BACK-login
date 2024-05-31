package com.example.loginback.Security.Authlogin.Auth;

import com.example.loginback.Entity.Recordatorio;
import com.example.loginback.IRepository.RecordatorioRepository;
import com.example.loginback.Security.Authlogin.Jwt.JwtService;

import com.example.loginback.Security.Entity.Role;
import com.example.loginback.Security.Entity.User;
import com.example.loginback.Security.IRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RecordatorioRepository RecordatorioRepository;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user); // El token debe contener información de rol

        // Devolver el token independientemente del rol, pero restringir acciones en otro lugar
        return AuthResponse.builder()
                .token(token)
                .build();
    }


    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.lastname)
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }
    public Recordatorio saveRecordatorio(RecordatorioRequest recordatorioRequest, String token) {
        String username = jwtService.getUsernameFromToken(token);
        User user = userRepository.findByUsername(username).orElseThrow();

        Recordatorio recordatorio = Recordatorio.builder()
                .titulo(recordatorioRequest.getTitulo())
                .descripcion(recordatorioRequest.getDescripcion())
                .fecha(recordatorioRequest.getFecha())
                .build();

        return RecordatorioRepository.save(recordatorio);
    }
    public Recordatorio updateRecordatorio(Long id, RecordatorioRequest request, String token) {
        String username = jwtService.getUsernameFromToken(token);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        Recordatorio recordatorio = RecordatorioRepository.findById(id).orElseThrow(() -> new RuntimeException("Recordatorio not found"));

        /* Verificar que el usuario sea el propietario del recordatorio
        if (!recordatorio.getUser().equals(user)) {
            throw new RuntimeException("User does not own this recordatorio");
        }  */

        // Actualizar el recordatorio con los nuevos datos
        recordatorio.setTitulo(request.getTitulo());
        recordatorio.setDescripcion(request.getDescripcion());
        recordatorio.setFecha(request.getFecha());

        // Guardar el recordatorio actualizado
        return RecordatorioRepository.save(recordatorio);
    }

    public void deleteRecordatorio(Long id, String token) {
        String username = jwtService.getUsernameFromToken(token);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        Recordatorio recordatorio = RecordatorioRepository.findById(id).orElseThrow(() -> new RuntimeException("Recordatorio not found"));

        /* Verificar que el usuario sea el propietario del recordatorio
        if (!recordatorio.getUser().equals(user)) {
            throw new RuntimeException("User does not own this recordatorio");
        } */

        // Eliminar el recordatorio
        RecordatorioRepository.delete(recordatorio);
    }



}