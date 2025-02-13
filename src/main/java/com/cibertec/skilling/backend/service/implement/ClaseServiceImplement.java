package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.ClaseNotFoundException;
import com.cibertec.skilling.backend.mapper.ClaseMapper;
import com.cibertec.skilling.backend.model.dto.request.ClaseRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.model.entity.Clase;
import com.cibertec.skilling.backend.repository.ClaseRepository;
import com.cibertec.skilling.backend.service.ClaseService;

@Service
public class ClaseServiceImplement implements ClaseService {
    @Autowired
    private final ClaseRepository claseRepository;

    @Autowired
    private final ClaseMapper claseMapper;

    public ClaseServiceImplement(ClaseRepository claseRepository, ClaseMapper claseMapper) {
        this.claseRepository = claseRepository;
        this.claseMapper = claseMapper;
    }

    @Override
    public List<ClaseResponseDTO> findAllClases() {
        return claseRepository.findAll()
            .stream()
            .map(claseMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ClaseResponseDTO findClaseById(Integer id) {
        return claseRepository.findById(id)
            .map(claseMapper::toResponseDTO)
            .orElseThrow(() -> new ClaseNotFoundException("[Error 404] Clas no encontrada con id: " + id));
    }

    @Override
    public ClaseResponseDTO createClase(ClaseRequestDTO requestDTO) {
        Clase clase = claseMapper.toEntity(requestDTO);
        Clase savedClase = claseRepository.save(clase);
        return claseMapper.toResponseDTO(savedClase);        
    }

    @Override
    public ClaseResponseDTO updateClase(Integer id, ClaseRequestDTO requestDTO) {
        Clase existingClase = claseRepository.findById(id)
            .orElseThrow(() -> new ClaseNotFoundException("[Error 404] Clase no encontrada con id: " + id));
        existingClase.setNombre(requestDTO.getNombre());
        existingClase.setCapacidad(requestDTO.getCapacidad());
        Clase updatedClase = claseRepository.save(existingClase);
        return claseMapper.toResponseDTO(updatedClase);
    }

    @Override
    public void deleteClase(Integer id) {
        Clase existingClase = claseRepository.findById(id)
            .orElseThrow(() -> new ClaseNotFoundException("[Error 404] Clase no encontrada con id: " + id));
        claseRepository.delete(existingClase);
    }
}
