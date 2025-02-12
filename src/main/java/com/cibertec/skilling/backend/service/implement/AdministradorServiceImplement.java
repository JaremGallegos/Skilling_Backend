package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.AdministradorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AdministradorResponseDTO;
import com.cibertec.skilling.backend.service.AdministradorService;

@Service
public class AdministradorServiceImplement implements AdministradorService {

    @Override
    public List<AdministradorResponseDTO> findAllAdministradores() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllAdministradores'");
    }

    @Override
    public AdministradorResponseDTO findAdministradorById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findAdministradorById'");
    }

    @Override
    public AdministradorResponseDTO createAdministrador(AdministradorRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createAdministrador'");
    }

    @Override
    public AdministradorResponseDTO updateAdministrador(String id, AdministradorRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateAdministrador'");
    }

    @Override
    public void deleteAdministrador(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAdministrador'");
    }
}
