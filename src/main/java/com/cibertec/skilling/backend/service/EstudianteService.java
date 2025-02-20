package com.cibertec.skilling.backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cibertec.skilling.backend.model.dto.request.EstudianteRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EstudianteResponseDTO;

public interface EstudianteService {
    List<EstudianteResponseDTO> findAllEstudiantes();
    EstudianteResponseDTO findEstudianteById(String id);
    EstudianteResponseDTO createEstudiante(EstudianteRequestDTO requestDTO);
    EstudianteResponseDTO updateEstudiante(String id, EstudianteRequestDTO requestDTO);
    void deleteEstudiante(String id);
}
