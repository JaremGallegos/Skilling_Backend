package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.ProfesorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;

public interface ProfesorService {
    List<ProfesorResponseDTO> findAllProfesores();
    ProfesorResponseDTO findProfesorById(String id);
    ProfesorResponseDTO createProfesor(ProfesorRequestDTO requestDTO);
    ProfesorResponseDTO updateProfesor(String id, ProfesorRequestDTO requestDTO);
    void deleteProfesor(String id);
}
