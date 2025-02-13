package com.cibertec.skilling.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
    List<Resultado> findByExamenId(Integer examenId);
    List<Resultado> findByTareaId(Integer tareaId);
    List<Resultado> findByEstudianteId(String estudianteId);
    Optional<Resultado> findByExamenIdAndTareaIdAndEstudianteId(Integer examenId, Integer tareaId, String estudianteId);
}
