package com.cibertec.skilling.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Integer> {
    List<Grado> findByNivelContainingIgnoreCase(String nivelFragment);
    List<Grado> findByNivel(String nivel);
}
