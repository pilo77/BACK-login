package com.example.loginback.IService;


import com.example.loginback.Entity.Recordatorio;

import java.util.List;
import java.util.Optional;


public interface RecordatorioService {
    Recordatorio save(Recordatorio recordatorio);

    Recordatorio update(Long id, Recordatorio recordatorio);

    Optional<Recordatorio> findById(Long id);

    List<Recordatorio> findAll();



}
