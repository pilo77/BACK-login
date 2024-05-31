package com.example.loginback.Security.Authlogin.Auth;

import com.example.loginback.Entity.Recordatorio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {


    private final AuthService authService;


    @Operation(summary = "Iniciar sesión")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthResponse.class))}),
            @ApiResponse(responseCode = "401", description = "Credenciales inválidas")
    })

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    //--------------------------------------------------------------------------------------------------
    @Operation(summary = "Registrar nuevo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro exitoso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Solicitud de registro inválida")
    })
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    //--------------------------------------------------------------------------------------------------
    @PostMapping("/recordatorio")
    public ResponseEntity<Recordatorio> saveRecordatorio(@RequestBody RecordatorioRequest request,
                                                         @RequestHeader("Authorization") String token) {
        String jwtToken = token.substring(7);// Eliminar "Bearer " del token
        Recordatorio recordatorio = authService.saveRecordatorio(request, jwtToken);
        return ResponseEntity.ok(recordatorio);
    }
    //--------------------------------------------------------------------------------------------------
    @PutMapping("/recordatorio/{id}")
    public ResponseEntity<Recordatorio> updateRecordatorio(@PathVariable Long id,
                                                           @RequestBody RecordatorioRequest request,
                                                           @RequestHeader("Authorization") String token) {
        String jwtToken = token.substring(7); // Eliminar "Bearer " del token
        Recordatorio recordatorio = authService.updateRecordatorio(id, request, jwtToken);
        return ResponseEntity.ok(recordatorio);
    }
    //--------------------------------------------------------------------------------------------------
    @DeleteMapping("/recordatorio/{id}")
    public ResponseEntity<Void> deleteRecordatorio(@PathVariable Long id,
                                                   @RequestHeader("Authorization") String token) {
        String jwtToken = token.substring(7); // Eliminar "Bearer " del token
        authService.deleteRecordatorio(id, jwtToken);
        return ResponseEntity.noContent().build();
    }
}
