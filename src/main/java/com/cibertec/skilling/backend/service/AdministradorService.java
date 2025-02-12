package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.AdministradorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AdministradorResponseDTO;

public interface AdministradorService {
    List<AdministradorResponseDTO> findAllAdministradores();
    AdministradorResponseDTO findAdministradorById(String id);
    AdministradorResponseDTO createAdministrador(AdministradorRequestDTO requestDTO);
    AdministradorResponseDTO updateAdministrador(String id, AdministradorRequestDTO requestDTO);
    void deleteAdministrador(String id); 
}
