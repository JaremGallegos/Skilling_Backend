package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.EstudianteRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EstudianteResponseDTO;
import com.cibertec.skilling.backend.service.EstudianteService;

@Service
public class EstudianteServiceImplement implements EstudianteService {

    @Override
    public List<EstudianteResponseDTO> findAllEstudiantes() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllEstudiantes'");
    }

    @Override
    public EstudianteResponseDTO findEstudianteById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findEstudianteById'");
    }

    @Override
    public EstudianteResponseDTO createEstudiante(EstudianteRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createEstudiante'");
    }

    @Override
    public EstudianteResponseDTO updateEstudiante(String id, EstudianteRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEstudiante'");
    }

    @Override
    public void deleteEstudiante(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteEstudiante'");
    }
}
