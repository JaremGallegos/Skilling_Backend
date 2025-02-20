package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.SimulacionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.SimulacionResponseDTO;

public interface SimulacionService {
    List<SimulacionResponseDTO> findAllSimulaciones();
    SimulacionResponseDTO findSimulacionById(String id);
    SimulacionResponseDTO createSimulacion(SimulacionRequestDTO requestDTO);
    SimulacionResponseDTO updateSimulacion(String id, SimulacionRequestDTO requestDTO);
    void deleteSimulacion(String id);
    
    List<SimulacionResponseDTO> processSimulacionesConThreads(List<SimulacionRequestDTO> dtos);
}
