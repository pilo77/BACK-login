package com.example.loginback.IService.impl;

import com.example.loginback.Entity.Categoria;
import com.example.loginback.IRepository.CategoriaRepository;
import com.example.loginback.IService.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        Categoria c = categoriaRepository.findById(id).orElse(null);

        if (c != null) {
            c.setTitulo(categoria.getTitulo());
            c.setDescripcion(categoria.getDescripcion());
            return categoriaRepository.save(c);
        }
        return null;

    }


    @Override
    public void delete(Long id) {

    }
}
