package com.cibertec.skilling.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.skilling.backend.model.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String> {
    Optional<Profesor> findByUsuario(String usuario);
    List<Profesor> findByNombreContainingIgnoreCase(String nombreFragment);
    List<Profesor> findByApellidoContainingIgnoreCase(String apellidoFragment);
    Optional<Profesor> findByCorreo(String correo);
}
