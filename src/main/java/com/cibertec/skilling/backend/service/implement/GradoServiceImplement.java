package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.GradoNotFoundException;
import com.cibertec.skilling.backend.mapper.GradoMapper;
import com.cibertec.skilling.backend.model.dto.request.GradoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GradoResponseDTO;
import com.cibertec.skilling.backend.model.entity.Grado;
import com.cibertec.skilling.backend.repository.GradoRepository;
import com.cibertec.skilling.backend.service.GradoService;

@Service
public class GradoServiceImplement implements GradoService {

    private final GradoRepository gradoRepository;
    private final GradoMapper gradoMapper;

    public GradoServiceImplement(GradoRepository gradoRepository, GradoMapper gradoMapper) {
        this.gradoRepository = gradoRepository;
        this.gradoMapper = gradoMapper;
    }

    @Override
    public List<GradoResponseDTO> findAllGrados() {
        return gradoRepository.findAll()
            .stream()
            .map(gradoMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public GradoResponseDTO findGradoById(Integer id) {
        return gradoRepository.findById(id)
            .map(gradoMapper::toResponseDTO)
            .orElseThrow(() -> new GradoNotFoundException("[Error 404] Grado no encontrado con id: " + id));
    }

    @Override
    public GradoResponseDTO createGrado(GradoRequestDTO requestDTO) {
        Grado grado = gradoMapper.toEntity(requestDTO);
        Grado savedGrado = gradoRepository.save(grado);
        return gradoMapper.toResponseDTO(savedGrado);
    }

    @Override
    public GradoResponseDTO updateGrado(Integer id, GradoRequestDTO requestDTO) {
        Grado existingGrado = gradoRepository.findById(id)
            .orElseThrow(() -> new GradoNotFoundException("[Error 404] Grado no encontrado con id: " + id));
        existingGrado.setNivel(requestDTO.getNivel());
        Grado updatedGrado = gradoRepository.save(existingGrado);
        return gradoMapper.toResponseDTO(updatedGrado);
    }

    @Override
    public void deleteGrado(Integer id) {
        Grado existingGrado = gradoRepository.findById(id)
            .orElseThrow(() -> new GradoNotFoundException("[Error 404] Grado no encontrado con id: " + id));
        gradoRepository.delete(existingGrado);
    }
}
