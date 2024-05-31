package com.example.loginback.IRepository;

import com.example.loginback.Entity.Recordatorio;
import com.example.loginback.Security.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {

    @Modifying
    @Query("update Recordatorio u set u.titulo = :#{#recordatorio.titulo}, u.descripcion = :#{#recordatorio.descripcion}, u.fecha = :#{#recordatorio.fecha}")
    void updateRecordatorio(@Param("recordatorio") Recordatorio recordatorio);
}