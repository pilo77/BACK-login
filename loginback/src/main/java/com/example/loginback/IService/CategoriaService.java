package com.example.loginback.IService;

import com.example.loginback.Entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria save(Categoria categoria);

    Categoria update(Long id, Categoria categoria);

    void delete(Long id);

    Optional<Categoria> findById(Long id);

    List<Categoria> findAll();
}