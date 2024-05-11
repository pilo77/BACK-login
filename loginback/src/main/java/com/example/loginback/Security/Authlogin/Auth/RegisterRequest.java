package com.example.loginback.Security.Authlogin.Auth;
import lombok .*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String firstname;
    String lastname;
    String country;
}
