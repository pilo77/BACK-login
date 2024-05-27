package com.example.loginback.Security.Controller;


import com.example.loginback.Security.Dto.UserDTO;
import com.example.loginback.Security.Dto.UserRequest;
import com.example.loginback.Security.Dto.UserResponse;
import com.example.loginback.Security.Service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/api/user")

@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping()

    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers(); // Asegúrate de obtener la lista de usuarios
        return ResponseEntity.ok(users); // Devuelve la lista de usuarios
    }

    @GetMapping(value = "{id}")

    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
        UserDTO userDTO = userService.getUser(id);
        if (userDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/modificar")

    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.updateUser(userRequest));
    }
}