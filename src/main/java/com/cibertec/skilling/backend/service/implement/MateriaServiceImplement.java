package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.MateriaNotFoundException;
import com.cibertec.skilling.backend.mapper.MateriaMapper;
import com.cibertec.skilling.backend.model.dto.request.MateriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.MateriaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Materia;
import com.cibertec.skilling.backend.repository.MateriaRepository;
import com.cibertec.skilling.backend.service.MateriaService;

@Service
public class MateriaServiceImplement implements MateriaService {
    @Autowired
    private final MateriaRepository materiaRepository;

    @Autowired
    private final MateriaMapper materiaMapper;

    public MateriaServiceImplement(MateriaRepository materiaRepository, MateriaMapper materiaMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaMapper = materiaMapper;
    }

    @Override
    public List<MateriaResponseDTO> findAllMaterias() {
        return materiaRepository.findAll()
            .stream()
            .map(materiaMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public MateriaResponseDTO findMateriaById(Integer id) {
        return materiaRepository.findById(id)
            .map(materiaMapper::toResponseDTO)
            .orElseThrow(() -> new MateriaNotFoundException("[Error 404] Materia no encontrada con id: " + id));
    }


    @Override
    public MateriaResponseDTO createMateria(MateriaRequestDTO requestDTO) {
        Materia materia = materiaMapper.toEntity(requestDTO);
        Materia savedMateria = materiaRepository.save(materia);
        return materiaMapper.toResponseDTO(savedMateria);
    }

    @Override
    public MateriaResponseDTO updateMateria(Integer id, MateriaRequestDTO requestDTO) {
        Materia existingMateria = materiaRepository.findById(id)
            .orElseThrow(() -> new MateriaNotFoundException("[Error 404] Materia no encontrada con id: " + id));
        existingMateria.setNombre(requestDTO.getNombre());
        Materia updatedMateria = materiaRepository.save(existingMateria);
        return materiaMapper.toResponseDTO(updatedMateria);
    }

    @Override
    public void deleteMateria(Integer id) {
        Materia existingMateria = materiaRepository.findById(id)
            .orElseThrow(() -> new MateriaNotFoundException("[Error 404] Materia no encontrada con id: " + id));
        materiaRepository.delete(existingMateria);
    }
}
