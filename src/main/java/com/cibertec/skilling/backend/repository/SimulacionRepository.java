package com.cibertec.skilling.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Simulacion;

@Repository
public interface SimulacionRepository extends JpaRepository<Simulacion, String> {

}
