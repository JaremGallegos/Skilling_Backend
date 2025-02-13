package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.LeccionNotFoundException;
import com.cibertec.skilling.backend.mapper.LeccionMapper;
import com.cibertec.skilling.backend.model.dto.request.LeccionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;
import com.cibertec.skilling.backend.model.entity.Leccion;
import com.cibertec.skilling.backend.repository.LeccionRepository;
import com.cibertec.skilling.backend.service.LeccionService;

@Service
public class LeccionServiceImplement implements LeccionService {
    @Autowired
    private final LeccionRepository leccionRepository;
    
    @Autowired
    private final LeccionMapper leccionMapper;

    public LeccionServiceImplement(LeccionRepository leccionRepository, LeccionMapper leccionMapper) {
        this.leccionRepository = leccionRepository;
        this.leccionMapper = leccionMapper;
    }

    @Override
    public List<LeccionResponseDTO> findAllLecciones() {
        return leccionRepository.findAll()
            .stream()
            .map(leccionMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public LeccionResponseDTO findLeccionById(Integer id) {
        return leccionRepository.findById(id)
            .map(leccionMapper::toResponseDTO)
            .orElseThrow(() -> new LeccionNotFoundException("[Error 404] Leccion no encontrada con id: " + id));
    }

    @Override
    public LeccionResponseDTO createLeccion(LeccionRequestDTO requestDTO) {
        Leccion leccion = leccionMapper.toEntity(requestDTO);
        Leccion savedLeccion = leccionRepository.save(leccion);
        return leccionMapper.toResponseDTO(savedLeccion);
    }

    @Override
    public LeccionResponseDTO updateLeccion(Integer id, LeccionRequestDTO requestDTO) {
        Leccion existingLeccion = leccionRepository.findById(id)
            .orElseThrow(() -> new LeccionNotFoundException("[Error 404] Leccion no encontrada con id: "+ id));
        existingLeccion.setNombre(requestDTO.getNombre());
        existingLeccion.setHoraInicio(requestDTO.getHoraInicio());
        existingLeccion.setHoraFin(requestDTO.getHoraFin());
        Leccion updatedLeccion = leccionRepository.save(existingLeccion);
        return leccionMapper.toResponseDTO(updatedLeccion);
    }

    @Override
    public void deleteLeccion(Integer id) {
        Leccion existingLeccion = leccionRepository.findById(id)
            .orElseThrow(() -> new LeccionNotFoundException("[Error 404] Leccion no encontrada con id: " + id));
        leccionRepository.delete(existingLeccion);
    }
}
