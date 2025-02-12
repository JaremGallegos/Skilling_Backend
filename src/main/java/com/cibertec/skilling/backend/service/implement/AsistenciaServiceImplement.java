package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.AsistenciaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AsistenciaResponseDTO;
import com.cibertec.skilling.backend.service.AsistenciaService;

@Service
public class AsistenciaServiceImplement implements AsistenciaService {

    @Override
    public List<AsistenciaResponseDTO> findAllAsistencias() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllAsistencias'");
    }

    @Override
    public AsistenciaResponseDTO findAsistenciaById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findAsistenciaById'");
    }

    @Override
    public AsistenciaResponseDTO createAsistencia(AsistenciaRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createAsistencia'");
    }

    @Override
    public AsistenciaResponseDTO updateAsistencia(Integer id, AsistenciaRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateAsistencia'");
    }

    @Override
    public void deleteAsistencia(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAsistencia'");
    }
}
