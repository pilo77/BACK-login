package com.example.loginback.Security.Service;

import com.example.loginback.Security.Dto.UserDTO;
import com.example.loginback.Security.Entity.Rol;
import com.example.loginback.Security.Entity.User;
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

    @Transactional
    public UserResponse updateUser(UserRequest userRequest) {
        User user = userRepository.findById(userRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setCountry(userRequest.getCountry());

        // Actualizar el rol del usuario si se proporciona un nuevo rol
        if (userRequest.getRolNombre() != null) {
            Optional<Rol> optionalRol = user.getRol().stream()
                    .filter(rol -> rol.getNombre().equals(userRequest.getRolNombre())) // Compara el nombre del rol
                    .findFirst();
            if (optionalRol.isPresent()) {
                Rol rol = optionalRol.get();
                user.getRol().clear();
                user.getRol().add(rol);
            }
        }

        userRepository.save(user);

        return new UserResponse("Los datos del usuario se actualizaron correctamente");
    }
    public UserDTO getUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null)//if
        {
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .country(user.getCountry())
                    .build();
            return userDTO;
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll(); // Obtener todos los usuarios

        return users.stream() // Transformar la lista de usuarios a UserDTO
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