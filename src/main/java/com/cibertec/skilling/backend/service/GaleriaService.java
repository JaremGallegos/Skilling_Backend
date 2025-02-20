package com.cibertec.skilling.backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cibertec.skilling.backend.model.dto.request.GaleriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GaleriaResponseDTO;

public interface GaleriaService {
    List<GaleriaResponseDTO> findAllGalerias();
    GaleriaResponseDTO findGaleriaById(String id);
    GaleriaResponseDTO createGaleria(GaleriaRequestDTO requestDTO);
    GaleriaResponseDTO updateGaleria(String id, GaleriaRequestDTO requestDTO);
    void deleteGaleria(String id);
    

    GaleriaResponseDTO subirGaleria(MultipartFile file, GaleriaRequestDTO requestDTO) throws Exception;
}
