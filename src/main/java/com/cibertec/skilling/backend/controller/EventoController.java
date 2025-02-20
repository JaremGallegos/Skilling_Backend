package com.cibertec.skilling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.skilling.backend.model.dto.request.EventoRequestDTO;
import com.cibertec.skilling.backend.model.dto.request.NotificationRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EventoResponseDTO;
import com.cibertec.skilling.backend.service.EventoService;
import com.cibertec.skilling.backend.service.implement.NotificationServiceImplement;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin({"*"})
public class EventoController {

    @Autowired
    private final EventoService eventoService;

    @Autowired
    private final NotificationServiceImplement notificacionService;

    public EventoController(EventoService eventoService, NotificationServiceImplement notificacionService) {
        this.eventoService = eventoService;
        this.notificacionService = notificacionService;
    }

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> getAllEventos() {
        List<EventoResponseDTO> eventos = eventoService.findAllEventos();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> getEventoById(@PathVariable("id") Integer id) {
        EventoResponseDTO evento = eventoService.findEventoById(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> createEvento(@RequestBody EventoRequestDTO requestDTO) {
        EventoResponseDTO createdEvento = eventoService.createEvento(requestDTO);
        return new ResponseEntity<>(createdEvento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> updateEvento(@PathVariable("id") Integer id,
                                                          @RequestBody EventoRequestDTO requestDTO) {
        EventoResponseDTO updatedEvento = eventoService.updateEvento(id, requestDTO);
        return ResponseEntity.ok(updatedEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable("id") Integer id) {
        eventoService.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 
     */
    @PostMapping("/enviar")
    public ResponseEntity<String> enviarNotificacion(@RequestBody NotificationRequestDTO request) {
        notificacionService.enviarEmail(request.getEmail(), request.getSubject(), request.getBody());
        return ResponseEntity.ok("Notificacion enviado correctamente");
    }
}
