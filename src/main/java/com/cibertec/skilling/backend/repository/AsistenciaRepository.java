package com.cibertec.skilling.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer>{
    List<Asistencia> findByFechaBetween(LocalDateTime start, LocalDateTime end);
    List<Asistencia> findByPresente(String presente);
    List<Asistencia> findByEstudianteId(String estudianteId);
    List<Asistencia> findByLeccionId(Integer leccionId);
}
