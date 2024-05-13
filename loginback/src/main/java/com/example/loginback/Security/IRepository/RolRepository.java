package com.example.loginback.Security.IRepository;

import com.example.loginback.Security.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {


    Optional<Rol> findByRolNombre(String rolNombre);
}