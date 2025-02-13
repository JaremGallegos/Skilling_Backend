package com.cibertec.skilling.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, String> {
    List<Administrador> findByUsuario(String usuario);
}
