package com.cibertec.skilling.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer>{
    List<Anuncio> findByTituloContainingIgnoreCase(String tituloFragment);
    List<Anuncio> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    List<Anuncio> findByClaseId(Integer claseId);
}
