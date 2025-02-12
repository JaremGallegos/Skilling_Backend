package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.ExamenRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ExamenResponseDTO;

public interface ExamenService {
    List<ExamenResponseDTO> findAllExamenes();
    ExamenResponseDTO findExamenById(Integer id);
    ExamenResponseDTO createExamen(ExamenRequestDTO requestDTO);
    ExamenResponseDTO updateExamen(Integer id, ExamenRequestDTO requestDTO);
    void deleteExamen(Integer id);
}
