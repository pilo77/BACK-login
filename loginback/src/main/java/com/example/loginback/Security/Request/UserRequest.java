package com.example.loginback.Security.Request;

import com.example.loginback.Security.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    int id;
    String username;
    String firstname;
    String lastname;
    String country;
    Role role;

}