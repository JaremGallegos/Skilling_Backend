package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.RolRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.RolResponseDTO;

public interface RolService {
    List<RolResponseDTO> findAllRoles();
    RolResponseDTO findRolById(Integer id);
    RolResponseDTO createRol(RolRequestDTO requestDTO);
    RolResponseDTO updateRol(Integer id, RolRequestDTO requestDTO);
    void deleteRol(Integer id);
}
