package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.GradoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GradoResponseDTO;
import com.cibertec.skilling.backend.service.GradoService;

@Service
public class GradoServiceImplement implements GradoService {

    @Override
    public List<GradoResponseDTO> findAllGrados() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllGrados'");
    }

    @Override
    public GradoResponseDTO findGradoById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findGradoById'");
    }

    @Override
    public GradoResponseDTO createGrado(GradoRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createGrado'");
    }

    @Override
    public GradoResponseDTO updateGrado(Integer id, GradoRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateGrado'");
    }

    @Override
    public void deleteGrado(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteGrado'");
    }
}
