package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.ClaseRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;

public interface ClaseService {
    List<ClaseResponseDTO> findAllClases();
    ClaseResponseDTO findClaseById(Integer id);
    ClaseResponseDTO createClase(ClaseRequestDTO requestDTO);
    ClaseResponseDTO updateClase(Integer id, ClaseRequestDTO requestDTO);
    void deleteClase(Integer id);
}
