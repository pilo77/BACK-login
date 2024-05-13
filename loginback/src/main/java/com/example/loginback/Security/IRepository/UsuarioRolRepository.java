package com.example.loginback.Security.IRepository;

import com.example.loginback.Security.Entity.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {
    // Aquí podrías agregar métodos personalizados para buscar o manipular los datos de UsuarioRol si es necesario
}
