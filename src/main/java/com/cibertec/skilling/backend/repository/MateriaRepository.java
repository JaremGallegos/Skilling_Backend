package com.cibertec.skilling.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    List<Materia> findByNombreContainingIgnoreCase(String nombreFragment);
    Optional<Materia> findByNombre(String nombre);
}
