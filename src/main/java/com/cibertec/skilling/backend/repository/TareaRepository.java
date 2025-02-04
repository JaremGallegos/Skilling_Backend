package com.cibertec.skilling.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

}
