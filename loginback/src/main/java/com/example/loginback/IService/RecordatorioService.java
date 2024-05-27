package com.example.loginback.IService;

import com.example.loginback.Entity.Categoria;
import com.example.loginback.IService.impl.Recordatorio;

import java.util.List;
import java.util.Optional;


public interface RecordatorioService {
    Recordatorio save(Recordatorio recordatorio);

    void update(Recordatorio recordatorio, Long id);

    void delete(Long id);

    Optional<Recordatorio> findById(Long id);

    List<Recordatorio> findAll();


}
