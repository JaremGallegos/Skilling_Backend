package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.EstudianteNotFoundException;
import com.cibertec.skilling.backend.mapper.EstudianteMapper;
import com.cibertec.skilling.backend.model.dto.request.EstudianteRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EstudianteResponseDTO;
import com.cibertec.skilling.backend.model.entity.Estudiante;
import com.cibertec.skilling.backend.repository.EstudianteRepository;
import com.cibertec.skilling.backend.service.EstudianteService;

@Service
public class EstudianteServiceImplement implements EstudianteService {
    @Autowired
    private final EstudianteRepository estudianteRepository;
    
    @Autowired
    private final EstudianteMapper estudianteMapper;

    public EstudianteServiceImplement(EstudianteRepository estudianteRepository, EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteMapper = estudianteMapper;
    }

    @Override
    public List<EstudianteResponseDTO> findAllEstudiantes() {
        return estudianteRepository.findAll()
            .stream()
            .map(estudianteMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public EstudianteResponseDTO findEstudianteById(String id) {
        return estudianteRepository.findById(id)
            .map(estudianteMapper::toResponseDTO)
            .orElseThrow(() -> new EstudianteNotFoundException("[Error 404] Estudiante no encontrado con id: " + id));
    }

    @Override
    public EstudianteResponseDTO createEstudiante(EstudianteRequestDTO requestDTO) {
        Estudiante estudiante = estudianteMapper.toEntity(requestDTO);
        Estudiante savedEstudiante = estudianteRepository.save(estudiante);
        return estudianteMapper.toResponseDTO(savedEstudiante);
    }

    @Override
    public EstudianteResponseDTO updateEstudiante(String id, EstudianteRequestDTO requestDTO) {
        Estudiante existingEstudiante = estudianteRepository.findById(id)
            .orElseThrow(() -> new EstudianteNotFoundException("[Error 404] Estudiante no encontrado con id: " + id));
        existingEstudiante.setUsuario(requestDTO.getUsuario());
        existingEstudiante.setNombre(requestDTO.getNombre());
        existingEstudiante.setApellido(requestDTO.getApellido());
        existingEstudiante.setCorreo(requestDTO.getCorreo());
        existingEstudiante.setTelefono(requestDTO.getTelefono());
        existingEstudiante.setDireccion(requestDTO.getDireccion());
        existingEstudiante.setImagen(requestDTO.getImagen());
        existingEstudiante.setFechaNacimiento(requestDTO.getFechaNacimiento());
        Estudiante updatedEstudiante = estudianteRepository.save(existingEstudiante);
        return estudianteMapper.toResponseDTO(updatedEstudiante);
    }

    @Override
    public void deleteEstudiante(String id) {
        Estudiante existingEstudiante = estudianteRepository.findById(id)
            .orElseThrow(() -> new EstudianteNotFoundException("[Error 404] Estudiante no encontrado con id: " + id));
        estudianteRepository.delete(existingEstudiante);
    }
}
