package com.example.loginback.Security.Service;

import com.example.loginback.Security.Dto.UserDTO;
import com.example.loginback.Security.Entity.Rol;
import com.example.loginback.Security.Entity.User;
import com.example.loginback.Security.Entity.UsuarioRol;
import com.example.loginback.Security.IRepository.RolRepository;
import com.example.loginback.Security.IRepository.UserRepository;
import com.example.loginback.Security.Request.UserRequest;
import com.example.loginback.Security.Response.UserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RolRepository rolRepository;

    @Transactional
    public UserResponse updateUser(UserRequest userRequest) {
        User user = userRepository.findById(userRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setCountry(userRequest.getCountry());

        // Actualizar el rol del usuario si se proporciona un nuevo rol
        if (userRequest.getRolNombre() != null) {
            Rol rol = rolRepository.findByNombre(userRequest.getRolNombre())
                    .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado"));

            user.getUsuarioRoles().clear(); // Eliminar roles anteriores
            user.getUsuarioRoles().add(new UsuarioRol(user, rol));
        }

        userRepository.save(user);

        return new UserResponse("Los datos del usuario se actualizaron correctamente");
    }

    public UserDTO getUser(Integer id) {
        return userRepository.findById(id)
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .country(user.getCountry())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream() // Obtener todos los usuarios
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .country(user.getCountry())
                        .build())
                .collect(Collectors.toList());
    }
}