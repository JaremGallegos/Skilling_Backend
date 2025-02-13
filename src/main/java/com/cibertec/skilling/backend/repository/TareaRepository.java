package com.cibertec.skilling.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByTituloContainingIgnoreCase(String tituloFragment);
    List<Tarea> findByFechaInicioBetween(LocalDateTime start, LocalDateTime end);
    List<Tarea> findByFechaEntregaBetween(LocalDateTime start, LocalDateTime end);
    List<Tarea> findByLeccionId(Integer leccionId);
}
