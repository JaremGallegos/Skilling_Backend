package com.cibertec.skilling.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
    List<Estudiante> findByNombreContainingIgnoreCase(String nombreFragment);
    List<Estudiante> findByApellidoContainingIgnoreCase(String apellidoFragment);
    List<Estudiante> findByGradoId(Integer gradoId);
    List<Estudiante> findByClaseId(Integer claseId);
    Estudiante findByUsuario(String usuario);
}
