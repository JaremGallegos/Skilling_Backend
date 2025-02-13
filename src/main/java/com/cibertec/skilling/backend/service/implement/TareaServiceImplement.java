package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.TareaNotFoundException;
import com.cibertec.skilling.backend.mapper.TareaMapper;
import com.cibertec.skilling.backend.model.dto.request.TareaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.TareaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Tarea;
import com.cibertec.skilling.backend.repository.TareaRepository;
import com.cibertec.skilling.backend.service.TareaService;

@Service
public class TareaServiceImplement implements TareaService {
    @Autowired
    private final TareaRepository tareaRepository;

    @Autowired
    private final TareaMapper tareaMapper;

    public TareaServiceImplement(TareaRepository tareaRepository, TareaMapper tareaMapper) {
        this.tareaRepository = tareaRepository;
        this.tareaMapper = tareaMapper;
    }

    @Override
    public List<TareaResponseDTO> findAllTareas() {
        return tareaRepository.findAll()
            .stream()
            .map(tareaMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public TareaResponseDTO findTareaById(Integer id) {
        return tareaRepository.findById(id)
            .map(tareaMapper::toResponseDTO)
            .orElseThrow(() -> new TareaNotFoundException("[Error 404] Tarea no encontrada con id: " + id));
    }

    @Override
    public TareaResponseDTO createTarea(TareaRequestDTO requestDTO) {
        Tarea tarea = tareaMapper.toEntity(requestDTO);
        Tarea savedTarea = tareaRepository.save(tarea);
        return tareaMapper.toResponseDTO(savedTarea);
    }

    @Override
    public TareaResponseDTO updateTarea(Integer id, TareaRequestDTO requestDTO) {
        Tarea existingTarea = tareaRepository.findById(id)
            .orElseThrow(() -> new TareaNotFoundException("[Error 404] Tarea no encontrada con id: " + id));
        existingTarea.setTitulo(requestDTO.getTitulo());
        existingTarea.setFechaInicio(requestDTO.getFechaInicio());
        existingTarea.setFechaEntrega(requestDTO.getFechaEntrega());
        Tarea updatedTarea = tareaRepository.save(existingTarea);
        return tareaMapper.toResponseDTO(updatedTarea);
    }

    @Override
    public void deleteTarea(Integer id) {
        Tarea existingTarea = tareaRepository.findById(id)
            .orElseThrow(() -> new TareaNotFoundException("[Error 404] Tarea no encontrada con id: " + id));
        tareaRepository.delete(existingTarea);
    }
}
