package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.ClaseRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.service.ClaseService;

@Service
public class ClaseServiceImplement implements ClaseService {

    @Override
    public List<ClaseResponseDTO> findAllClases() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllClases'");
    }

    @Override
    public ClaseResponseDTO findClaseById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findClaseById'");
    }

    @Override
    public ClaseResponseDTO createClase(ClaseRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createClase'");
    }

    @Override
    public ClaseResponseDTO updateClase(Integer id, ClaseRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateClase'");
    }

    @Override
    public void deleteClase(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteClase'");
    }
}
