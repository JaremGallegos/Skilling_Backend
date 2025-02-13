package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.AsistenciaNotFoundException;
import com.cibertec.skilling.backend.mapper.AsistenciaMapper;
import com.cibertec.skilling.backend.model.dto.request.AsistenciaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AsistenciaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Asistencia;
import com.cibertec.skilling.backend.repository.AsistenciaRepository;
import com.cibertec.skilling.backend.service.AsistenciaService;

@Service
public class AsistenciaServiceImplement implements AsistenciaService {
    @Autowired
    private final AsistenciaRepository asistenciaRepository;    

    @Autowired
    private final AsistenciaMapper asistenciaMapper;

    public AsistenciaServiceImplement(AsistenciaRepository asistenciaRepository, AsistenciaMapper asistenciaMapper) {
        this.asistenciaRepository = asistenciaRepository;
        this.asistenciaMapper = asistenciaMapper;
    }

    @Override
    public List<AsistenciaResponseDTO> findAllAsistencias() {
        return asistenciaRepository.findAll()
            .stream()
            .map(asistenciaMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public AsistenciaResponseDTO findAsistenciaById(Integer id) {
        return asistenciaRepository.findById(id)
            .map(asistenciaMapper::toResponseDTO)
            .orElseThrow(() -> new AsistenciaNotFoundException("[Error 404] Asistencia no encontrada con id: " + id));
    }

    @Override
    public AsistenciaResponseDTO createAsistencia(AsistenciaRequestDTO requestDTO) {
        Asistencia asistencia = asistenciaMapper.toEntity(requestDTO);
        Asistencia savedAsistencia = asistenciaRepository.save(asistencia);
        return asistenciaMapper.toResponseDTO(savedAsistencia);
    }

    @Override
    public AsistenciaResponseDTO updateAsistencia(Integer id, AsistenciaRequestDTO requestDTO) {
        Asistencia existingAsistencia = asistenciaRepository.findById(id)
            .orElseThrow(() -> new AsistenciaNotFoundException("[Error 404] Asistencia no encontrada con id: " + id));
        existingAsistencia.setFecha(requestDTO.getFecha());
        existingAsistencia.setPresente(requestDTO.getPresente());
        Asistencia updatedAsistencia = asistenciaRepository.save(existingAsistencia);
        return asistenciaMapper.toResponseDTO(updatedAsistencia);
    }

    @Override
    public void deleteAsistencia(Integer id) {
        Asistencia existingAsistencia = asistenciaRepository.findById(id)
            .orElseThrow(() -> new AsistenciaNotFoundException("[Error 404] Asistencia no encontrada con id: " + id));
        asistenciaRepository.delete(existingAsistencia);
    }
}
