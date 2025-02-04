package com.cibertec.skilling.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {

}
