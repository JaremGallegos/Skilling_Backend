package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.EventoNotFoundException;
import com.cibertec.skilling.backend.mapper.EventoMapper;
import com.cibertec.skilling.backend.model.dto.request.EventoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EventoResponseDTO;
import com.cibertec.skilling.backend.model.entity.Evento;
import com.cibertec.skilling.backend.repository.EventoRepository;
import com.cibertec.skilling.backend.service.EventoService;

@Service
public class EventoServiceImplement implements EventoService {
    @Autowired
    private final EventoRepository eventoRepository;

    @Autowired
    private final EventoMapper eventoMapper;

    public EventoServiceImplement(EventoRepository eventoRepository, EventoMapper eventoMapper) {
        this.eventoRepository = eventoRepository;
        this.eventoMapper = eventoMapper;
    }

    @Override
    public List<EventoResponseDTO> findAllEventos() {
        return eventoRepository.findAll()
            .stream()
            .map(eventoMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public EventoResponseDTO findEventoById(Integer id) {
        return eventoRepository.findById(id)
            .map(eventoMapper::toResponseDTO)
            .orElseThrow(() -> new EventoNotFoundException("[Error 404] Evento no encontrado con id: " + id));
    }

    @Override
    public EventoResponseDTO createEvento(EventoRequestDTO requestDTO) {
        Evento evento = eventoMapper.toEntity(requestDTO);
        Evento savedEvento = eventoRepository.save(evento);
        return eventoMapper.toResponseDTO(savedEvento);
    }

    @Override
    public EventoResponseDTO updateEvento(Integer id, EventoRequestDTO requestDTO) {
        Evento existingEvento = eventoRepository.findById(id)
            .orElseThrow(() -> new EventoNotFoundException("[Error 404] Evento no encontrado con id: " + id));
        existingEvento.setTitulo(requestDTO.getTitulo());
        existingEvento.setDescripcion(requestDTO.getDescripcion());
        existingEvento.setHoraInicio(requestDTO.getHoraInicio());
        existingEvento.setHoraFin(requestDTO.getHoraFin());
        Evento updatedEvento = eventoRepository.save(existingEvento);
        return eventoMapper.toResponseDTO(updatedEvento);
    }

    @Override
    public void deleteEvento(Integer id) {
        Evento existingEvento = eventoRepository.findById(id)
            .orElseThrow(() -> new EventoNotFoundException("[Error 404] Evento no encontrado con id: " + id));
        eventoRepository.delete(existingEvento);
    }
}
