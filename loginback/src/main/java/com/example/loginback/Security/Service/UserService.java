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
        Optional<User> optionalUser = userRepository.findById(userRequest.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Aquí deberías tener la lógica para actualizar el usuario con los datos de userRequest
            userRepository.save(user);
            return new UserResponse("Los datos del usuario se actualizaron correctamente");
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
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
        return userRepository.findAll().stream()
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
