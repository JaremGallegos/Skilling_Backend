package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.LeccionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;

public interface LeccionService {
    List<LeccionResponseDTO> findAllLecciones();
    LeccionResponseDTO findLeccionById(Integer id);
    LeccionResponseDTO createLeccion(LeccionRequestDTO requestDTO);
    LeccionResponseDTO updateLeccion(Integer id, LeccionRequestDTO requestDTO);
    void deleteLeccion(Integer id);
}
