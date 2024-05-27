package com.example.loginback.IRepository;

import com.example.loginback.Entity.Recordatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {
    @Query("SELECT r FROM Recordatorio r WHERE r.activo = true")
    List<Recordatorio> findAllActive();

    @Query("SELECT COUNT(r) FROM Recordatorio r WHERE r.activo = true")
    Long countActiveRecordatorios();
}