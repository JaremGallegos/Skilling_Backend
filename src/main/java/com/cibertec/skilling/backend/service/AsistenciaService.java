package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.AsistenciaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AsistenciaResponseDTO;

public interface AsistenciaService {
    List<AsistenciaResponseDTO> findAllAsistencias();
    AsistenciaResponseDTO findAsistenciaById(Integer id);
    AsistenciaResponseDTO createAsistencia(AsistenciaRequestDTO requestDTO);
    AsistenciaResponseDTO updateAsistencia(Integer id, AsistenciaRequestDTO requestDTO);
    void deleteAsistencia(Integer id);
}
