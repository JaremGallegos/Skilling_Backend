package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.ExamenNotFoundException;
import com.cibertec.skilling.backend.mapper.ExamenMapper;
import com.cibertec.skilling.backend.model.dto.request.ExamenRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ExamenResponseDTO;
import com.cibertec.skilling.backend.model.entity.Examen;
import com.cibertec.skilling.backend.repository.ExamenRepository;
import com.cibertec.skilling.backend.service.ExamenService;

@Service
public class ExamenServiceImplement implements ExamenService {
    @Autowired
    private final ExamenRepository examenRepository;

    @Autowired
    private final ExamenMapper examenMapper;

    public ExamenServiceImplement(ExamenRepository examenRepository, ExamenMapper examenMapper){
        this.examenRepository = examenRepository;
        this.examenMapper = examenMapper;
    } 

    @Override
    public List<ExamenResponseDTO> findAllExamenes() {
        return examenRepository.findAll()
            .stream()
            .map(examenMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ExamenResponseDTO findExamenById(Integer id) {
        return examenRepository.findById(id)
            .map(examenMapper::toResponseDTO)
            .orElseThrow(() -> new ExamenNotFoundException("[Error 404] Examen no encontrado con id: " + id));
    }

    @Override
    public ExamenResponseDTO createExamen(ExamenRequestDTO requestDTO) {
        Examen examen = examenMapper.toEntity(requestDTO);
        Examen savedExamen = examenRepository.save(examen);
        return examenMapper.toResponseDTO(savedExamen);
    }

    @Override
    public ExamenResponseDTO updateExamen(Integer id, ExamenRequestDTO requestDTO) {
        Examen existingExamen = examenRepository.findById(id)
            .orElseThrow(() -> new ExamenNotFoundException("[Error 404] Examen no encontrado con id: " + id));
        existingExamen.setTitulo(requestDTO.getTitulo());
        existingExamen.setHoraInicio(requestDTO.getHoraInicio());
        existingExamen.setHoraFin(requestDTO.getHoraFin());
        Examen updatedExamen = examenRepository.save(existingExamen);
        return examenMapper.toResponseDTO(updatedExamen);
    }

    @Override
    public void deleteExamen(Integer id) {
        Examen existingExamen = examenRepository.findById(id)
            .orElseThrow(() -> new ExamenNotFoundException("[Error 404] Examen no encontrado con id: " + id));
        examenRepository.delete(existingExamen);
    }
}
