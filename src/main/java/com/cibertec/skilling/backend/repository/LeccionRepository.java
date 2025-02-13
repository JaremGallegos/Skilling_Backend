package com.cibertec.skilling.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.Dia;
import com.cibertec.skilling.backend.model.entity.Leccion;

@Repository
public interface LeccionRepository extends JpaRepository<Leccion, Integer> {
    List<Leccion> findByNombreContainingIgnoreCase(String nombreFragment);
    List<Leccion> findByDia(Dia dia);
    List<Leccion> findByHoraInicioBetween(LocalDateTime start, LocalDateTime end);
    List<Leccion> findByMateriaId(Integer materiaId);
    List<Leccion> findByClaseId(Integer claseId);
    List<Leccion> findByProfesorId(String profesorId);
}
