package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.SimulacionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.SimulacionResponseDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface SimulacionService {
    List<SimulacionResponseDTO> findAllSimulaciones();
    SimulacionResponseDTO findSimulacionById(String id);
    SimulacionResponseDTO createSimulacion(SimulacionRequestDTO requestDTO);
    SimulacionResponseDTO updateSimulacion(String id, SimulacionRequestDTO requestDTO);
    void deleteSimulacion(String id);
    
    List<SimulacionResponseDTO> procesarSimulacionesConThreads(List<SimulacionRequestDTO> dtos);
    List<SimulacionResponseDTO> uploadSimulacionesFromJsonl(MultipartFile file) throws Exception;
    Resource descargarCsvFile() throws Exception;
}
