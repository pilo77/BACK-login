package com.example.loginback.Security.Authlogin.Auth;
import lombok .*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    String username;
    String password;
}
