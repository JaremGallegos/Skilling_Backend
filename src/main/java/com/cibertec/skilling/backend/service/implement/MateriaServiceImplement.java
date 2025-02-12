package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.MateriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.MateriaResponseDTO;
import com.cibertec.skilling.backend.service.MateriaService;

@Service
public class MateriaServiceImplement implements MateriaService {

    @Override
    public List<MateriaResponseDTO> findAllMaterias() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllMaterias'");
    }

    @Override
    public MateriaResponseDTO findMateriaById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findMateriaById'");
    }

    @Override
    public MateriaResponseDTO createMateria(MateriaRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createMateria'");
    }

    @Override
    public MateriaResponseDTO updateMateria(Integer id, MateriaRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateMateria'");
    }

    @Override
    public void deleteMateria(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteMateria'");
    }
}
