package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.MateriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.MateriaResponseDTO;

public interface MateriaService {
    List<MateriaResponseDTO> findAllMaterias();
    MateriaResponseDTO findMateriaById(Integer id);
    MateriaResponseDTO createMateria(MateriaRequestDTO requestDTO);
    MateriaResponseDTO updateMateria(Integer id, MateriaRequestDTO requestDTO);
    void deleteMateria(Integer id);
}
