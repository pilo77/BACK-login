package com.example.loginback.Security.IRepository;

import com.example.loginback.Security.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}