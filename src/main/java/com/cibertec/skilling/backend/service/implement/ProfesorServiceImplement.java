package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.ProfesorNotFoundException;
import com.cibertec.skilling.backend.mapper.ProfesorMapper;
import com.cibertec.skilling.backend.model.dto.request.ProfesorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.model.entity.Profesor;
import com.cibertec.skilling.backend.repository.ProfesorRepository;
import com.cibertec.skilling.backend.service.ProfesorService;

@Service
public class ProfesorServiceImplement implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    public ProfesorServiceImplement(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
    }

    @Override
    public List<ProfesorResponseDTO> findAllProfesores() {
        return profesorRepository.findAll()
            .stream()
            .map(profesorMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ProfesorResponseDTO findProfesorById(String id) {
        return profesorRepository.findById(id)
            .map(profesorMapper::toResponseDTO)
            .orElseThrow(() -> new ProfesorNotFoundException("[Error 404] Profesor no encontrado con id: " + id));
    }

    @Override
    public ProfesorResponseDTO createProfesor(ProfesorRequestDTO requestDTO) { 
        Profesor profesor = profesorMapper.toEntity(requestDTO);
        Profesor savedProfesor = profesorRepository.save(profesor);
        return profesorMapper.toResponseDTO(savedProfesor);
    }

    @Override
    public ProfesorResponseDTO updateProfesor(String id, ProfesorRequestDTO requestDTO) {
        Profesor existingProfesor = profesorRepository.findById(id)
            .orElseThrow(() -> new ProfesorNotFoundException("[Error 404] Profesor no encontrado con id: " + id));
        existingProfesor.setUsuario(requestDTO.getUsuario());
        existingProfesor.setNombre(requestDTO.getNombre());
        existingProfesor.setApellido(requestDTO.getApellido());
        existingProfesor.setCorreo(requestDTO.getCorreo());
        existingProfesor.setTelefono(requestDTO.getTelefono());
        existingProfesor.setDireccion(requestDTO.getDireccion());
        existingProfesor.setImagen(requestDTO.getImagen());
        existingProfesor.setFechaNacimiento(requestDTO.getFechaNacimiento());
        Profesor updatedProfesor = profesorRepository.save(existingProfesor);
        return profesorMapper.toResponseDTO(updatedProfesor);
    }

    @Override
    public void deleteProfesor(String id) {
        Profesor existingProfesor = profesorRepository.findById(id)
            .orElseThrow(() -> new ProfesorNotFoundException("[Error 404] Profesor no encontrado con id: " + id));
        profesorRepository.delete(existingProfesor);
    }
}
