package com.cibertec.skilling.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {
    List<Examen> findByTituloContainingIgnoreCase(String tituloFragment);
    List<Examen> findByHoraInicioBetween(LocalDateTime start, LocalDateTime end);
    List<Examen> findByLeccionId(Integer leccionId);
}
