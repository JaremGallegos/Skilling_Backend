package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.ProfesorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.service.ProfesorService;

@Service
public class ProfesorServiceImplement implements ProfesorService {

    @Override
    public List<ProfesorResponseDTO> findAllProfesores() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllProfesores'");
    }

    @Override
    public ProfesorResponseDTO findProfesorById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findProfesorById'");
    }

    @Override
    public ProfesorResponseDTO createProfesor(ProfesorRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createProfesor'");
    }

    @Override
    public ProfesorResponseDTO updateProfesor(String id, ProfesorRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateProfesor'");
    }

    @Override
    public void deleteProfesor(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfesor'");
    }
}
