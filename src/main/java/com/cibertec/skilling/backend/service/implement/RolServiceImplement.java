package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.RolRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.RolResponseDTO;
import com.cibertec.skilling.backend.service.RolService;

@Service
public class RolServiceImplement implements RolService {

    @Override
    public List<RolResponseDTO> findAllRoles() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllRoles'");
    }

    @Override
    public RolResponseDTO findRolById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findRolById'");
    }

    @Override
    public RolResponseDTO createRol(RolRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createRol'");
    }

    @Override
    public RolResponseDTO updateRol(Integer id, RolRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateRol'");
    }

    @Override
    public void deleteRol(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteRol'");
    }
}
