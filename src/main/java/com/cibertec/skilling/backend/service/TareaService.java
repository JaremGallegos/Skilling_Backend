package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.TareaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.TareaResponseDTO;

public interface TareaService {
    List<TareaResponseDTO> findAllTareas();
    TareaResponseDTO findTareaById(Integer id);
    TareaResponseDTO createTarea(TareaRequestDTO requestDTO);
    TareaResponseDTO updateTarea(Integer id, TareaRequestDTO requestDTO);
    void deleteTarea(Integer id);
}
