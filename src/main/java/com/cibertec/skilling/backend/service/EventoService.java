package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.EventoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EventoResponseDTO;

public interface EventoService {
    List<EventoResponseDTO> findAllEventos();
    EventoResponseDTO findEventoById(Integer id);
    EventoResponseDTO createEvento(EventoRequestDTO requestDTO);
    EventoResponseDTO updateEvento(Integer id, EventoRequestDTO requestDTO);
    void deleteEvento(Integer id);
}
