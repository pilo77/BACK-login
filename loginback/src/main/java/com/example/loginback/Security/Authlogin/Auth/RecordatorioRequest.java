package com.example.loginback.Security.Authlogin.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordatorioRequest {
    String titulo;
    String descripcion;
    String fecha;
}
