package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.ExamenRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ExamenResponseDTO;
import com.cibertec.skilling.backend.service.ExamenService;

@Service
public class ExamenServiceImplement implements ExamenService {

    @Override
    public List<ExamenResponseDTO> findAllExamenes() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllExamenes'");
    }

    @Override
    public ExamenResponseDTO findExamenById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findExamenById'");
    }

    @Override
    public ExamenResponseDTO createExamen(ExamenRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createExamen'");
    }

    @Override
    public ExamenResponseDTO updateExamen(Integer id, ExamenRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateExamen'");
    }

    @Override
    public void deleteExamen(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteExamen'");
    }
}
