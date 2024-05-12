package com.example.loginback.Security.Entity;

import com.example.loginback.Entity.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {
    @Id
    @GeneratedValue
    Integer id;
    @Basic
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String lastname;
    private String firstname;
    private String country;
    private String password;
    @Enumerated(EnumType.STRING)
    Rol rol;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Person person;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        Set<Authority> autoridades = new HashSet<>();
        this.userRoles.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getRolNombre()));
        });
        return autoridades;
    }
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}