package com.example.loginback.Security.Controller;

import com.example.loginback.Security.Dto.UserDTO;
import com.example.loginback.Security.Dto.UserRequest;
import com.example.loginback.Security.Dto.UserResponse;
import com.example.loginback.Security.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Obtener todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Éxito al obtener todos los usuarios",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "403", description = "Acceso denegado debido a permisos insuficientes", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)})
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Obtener un usuario por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Éxito al obtener el usuario",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)})
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
        UserDTO userDTO = userService.getUser(id);
        if (userDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @Operation(summary = "Actualizar un usuario")
    @ApiResponse(responseCode = "200", description = "Éxito al actualizar el usuario",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserResponse.class))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta o datos faltantes", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)})
    @PutMapping("/modificar")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.updateUser(userRequest));
    }

    @Operation(summary = "Eliminar un usuario por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado con éxito",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)})
    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Integer id) {
        UserResponse response = userService.deleteUserById(id);
        return ResponseEntity.ok(response);
    }
}

