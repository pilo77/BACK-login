package com.example.loginback.IService.impl;

import com.example.loginback.Entity.Recordatorio;
import com.example.loginback.IRepository.RecordatorioRepository;
import com.example.loginback.IService.RecordatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordatorioServiceImpl implements RecordatorioService {
    private RecordatorioRepository recordatorioRepository;

    @Override
    public List<Recordatorio> findAll() {
        return recordatorioRepository.findAll();
    }

    @Override
    public Recordatorio save(Recordatorio recordatorio) {
        return recordatorioRepository.save(recordatorio);
    }

    @Override
    public Recordatorio update(Long id, Recordatorio recordatorio) {
        Recordatorio r = recordatorioRepository.findById(id).orElse(null);
        if (r != null) {
            r.setTitulo(recordatorio.getTitulo());
            r.setDescripcion(recordatorio.getDescripcion());
            r.setFecha(recordatorio.getFecha());
            r.setHora(recordatorio.getHora());
            return recordatorioRepository.save(r); // Guardar el objeto r actualizado, no el objeto recordatorio
        }
        return null;
    }


    @Override
    public Optional<Recordatorio> findById(Long id) {
        return recordatorioRepository.findById(id);
    }


    @Override
    public Long countRecordatorios() {
        return recordatorioRepository.count();
    }

    @Override
    public void delete(Long id) {
        recordatorioRepository.deleteById(id);

    }
}
