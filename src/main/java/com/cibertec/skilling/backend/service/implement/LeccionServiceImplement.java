package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.LeccionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;
import com.cibertec.skilling.backend.service.LeccionService;

@Service
public class LeccionServiceImplement implements LeccionService {

    @Override
    public List<LeccionResponseDTO> findAllLecciones() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllLecciones'");
    }

    @Override
    public LeccionResponseDTO findLeccionById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findLeccionById'");
    }

    @Override
    public LeccionResponseDTO createLeccion(LeccionRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createLeccion'");
    }

    @Override
    public LeccionResponseDTO updateLeccion(Integer id, LeccionRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateLeccion'");
    }

    @Override
    public void deleteLeccion(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteLeccion'");
    }
}
