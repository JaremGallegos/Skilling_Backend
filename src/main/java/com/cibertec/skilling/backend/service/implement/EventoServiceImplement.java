package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.EventoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EventoResponseDTO;
import com.cibertec.skilling.backend.service.EventoService;

@Service
public class EventoServiceImplement implements EventoService {

    @Override
    public List<EventoResponseDTO> findAllEventos() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllEventos'");
    }

    @Override
    public EventoResponseDTO findEventoById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findEventoById'");
    }

    @Override
    public EventoResponseDTO createEvento(EventoRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createEvento'");
    }

    @Override
    public EventoResponseDTO updateEvento(Integer id, EventoRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEvento'");
    }

    @Override
    public void deleteEvento(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvento'");
    }
}
