package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.GradoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GradoResponseDTO;

public interface GradoService {
    List<GradoResponseDTO> findAllGrados();
    GradoResponseDTO findGradoById(Integer id);
    GradoResponseDTO createGrado(GradoRequestDTO requestDTO);
    GradoResponseDTO updateGrado(Integer id, GradoRequestDTO requestDTO);
    void deleteGrado(Integer id);
}
