package com.cibertec.skilling.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByTituloContainingIgnoreCase(String tituloFragment);
    List<Evento> findByHoraInicioBetween(LocalDateTime start, LocalDateTime end);
    List<Evento> findByClaseId(Integer claseId);
}
