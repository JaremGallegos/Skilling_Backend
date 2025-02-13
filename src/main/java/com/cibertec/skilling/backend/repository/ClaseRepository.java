package com.cibertec.skilling.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer> {
    List<Clase> findByNombreContainingIgnoreCase(String nombreFragment);
    List<Clase> findByGradoId(Integer gradoId);
    List<Clase> finbByProfesorId(String profesorId);
    List<Clase> findByCapacidadGreaterThanEqual(Integer capacidad);
}
