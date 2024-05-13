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


import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

        // Obtener el rol del usuario o crear uno nuevo si es necesario
        Set<Rol> roles = user.getRol();
        if (roles == null) {
            roles = new HashSet<>(); // Crear un nuevo conjunto de roles
        }

        // Crear un nuevo rol y asignarle el nombre
        Rol rol = new Rol();
        rol.setNombre(userRequest.getRolNombre()); // Aquí utilizas el método getRolNombre()

        // Agregar el nuevo rol al conjunto de roles del usuario
        roles.add(rol);

        // Asignar el conjunto de roles actualizado al usuario
        user.setRol(roles);

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