package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.TareaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.TareaResponseDTO;
import com.cibertec.skilling.backend.service.TareaService;

@Service
public class TareaServiceImplement implements TareaService {

    @Override
    public List<TareaResponseDTO> findAllTareas() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllTareas'");
    }

    @Override
    public TareaResponseDTO findTareaById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findTareaById'");
    }

    @Override
    public TareaResponseDTO createTarea(TareaRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createTarea'");
    }

    @Override
    public TareaResponseDTO updateTarea(Integer id, TareaRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateTarea'");
    }

    @Override
    public void deleteTarea(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteTarea'");
    }
}
